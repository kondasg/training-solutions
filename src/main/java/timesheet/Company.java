package timesheet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Company {

    private final List<Employee> employees = new ArrayList<>();
    private final List<Project> projects = new ArrayList<>();
    private final List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    public Company(InputStream employeesFile, InputStream projectsFile) {
        readEmployeesFile(employeesFile);
        readProjectsFile(projectsFile);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    private void readEmployeesFile(InputStream employeesFile) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(employeesFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                employees.add(new Employee(splittedLine[0], splittedLine[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read " + employeesFile + " file", e);
        }
    }

    private void readProjectsFile(InputStream projectsFile) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(projectsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                projects.add(new Project(line));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read " + projectsFile + " file", e);
        }
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        timeSheetItems.add(new TimeSheetItem(employee, project, beginDate, endDate));
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        List<ReportLine> result = initReportLine();
        for (TimeSheetItem timeSheetItem : timeSheetItems) {
            if (timeSheetItem.getEmployee().getName().equals(employeeName)
                    && timeSheetItem.getBeginDate().getYear() == year
                    && timeSheetItem.getBeginDate().getMonthValue() == month) {
                for (ReportLine reportLine : result) {
                    if (reportLine.getProject().getName().equals(timeSheetItem.getProject().getName())) {
                        reportLine.addTime(timeSheetItem.hoursBetweenDates());
                    }
                }
            }
        }
        if (getSumTime(result) == 0) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    private List<ReportLine> initReportLine() {
        List<ReportLine> result = new ArrayList<>();
        for (Project project : projects) {
            result.add(new ReportLine(project, 0));
        }
        return result;
    }

    private int getSumTime(List<ReportLine> reportLines) {
        int sum = 0;
        for (ReportLine reportLine : reportLines) {
            sum += reportLine.getTime();
        }
        return sum;
    }

    public void printToFile(String employeeName, int year, int month, Path file) {
        List<ReportLine> reportLines = calculateProjectByNameYearMonth(employeeName, year, month);
        String[] output = new String[reportLines.size() + 1];
        output[0] = String.format("%s\t%d-%02d\t%d\n", employeeName, year, month, getSumTime(reportLines));
        int i = 1;
        for (ReportLine reportLine : reportLines) {
            if (reportLine.getTime() > 0) {
                output[i] = reportLine.getProject().getName() + "\t" + reportLine.getTime() + "\n";
                i++;
            }
        }
        writeToFile(file, output);
    }

    private void writeToFile(Path file, String[] output) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(Files.newBufferedWriter(file)))) {
            for (String s : output) {
                if (s != null) {
                    writer.write(s);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write " + file + " file", e);
        }
    }

}
