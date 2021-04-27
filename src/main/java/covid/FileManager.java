package covid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileManager implements Constants {

    private final CovidDao covidDao;
    private final Validation validation = new Validation();

    public FileManager(CovidDao covidDao) {
        this.covidDao = covidDao;
    }

    public void readBulkFile(String file) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(file))) {
            String line;
            int lineCounter = 0;
            int succesStorege = 0;
            List<String> wrongLines = new ArrayList<>();
            br.readLine();
            while ((line = br.readLine()) != null) {
                lineCounter++;
                String[] splittedLine = line.split(";");
                if (splittedLine.length == 5) {
                    succesStorege = lineFormatOk(line, succesStorege, wrongLines, splittedLine);
                } else {
                    wrongLines.add(line + " ### HIBA: Nem megfelelő sor formátum");
                }
            }
            System.out.println(writeGreenText("Beolvasott sorok száma: " + lineCounter));
            System.out.println(writeGreenText("Eltárolt sorok száma: " + succesStorege));
            printWrongLines(wrongLines);

        } catch (IOException ie) {
            System.out.println(writeRedText("File olvasási hiba!"));
        }
    }

    private int lineFormatOk(String line, int succesStorege, List<String> wrongLines, String[] splittedLine) {
        String name = splittedLine[0];
        String zip = splittedLine[1];
        String birth = splittedLine[2];
        String email = splittedLine[3];
        String taj = splittedLine[4];
        if (validation.isVlalidTaj(taj) && !covidDao.isDataExists("citizens", "taj", taj)) {
            if (validation.isVlalidName(name) && validation.isVlalidZip(zip)
                    && validation.isVlalidBirth(birth) && validation.isVlalidEmail(email)) {
                Citizen citizen = new Citizen(name, zip, LocalDate.parse(birth), email, taj);
                covidDao.insertCitizen(citizen);
                succesStorege++;
            } else {
                wrongLines.add(line + " ### HIBA: Nem megfelelő adat formátum");
            }
        } else {
            wrongLines.add(line + " ### HIBA: Nem érvényes TAJ formátum vagy nem létező TAJ");
        }
        return succesStorege;
    }

    private void printWrongLines(List<String> wrongLines) {
        if (wrongLines.size() > 0) {
            System.out.println(writeRedText("Hibás sorok:"));
            for (String wl : wrongLines) {
                System.out.println(writeRedText(wl));
            }
        }
    }

    public void writeGenerationFile(String zip, String file) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(file))) {
            writeFile(zip, writer);
            System.out.println(writeGreenText("Sikeres időpont generálás!"));
        } catch (IOException ioe) {
            throw new IllegalStateException("File írási hiba!", ioe);
        }
    }

    private void writeFile(String zip, BufferedWriter writer) {
        try {
            List<Citizen> citizens = covidDao.selectNonVaccination(zip);
            writer.write("Időpont;Név;Irányítószám;Születési dátum;E-mail cím;TAJ szám");
            writeDataLines(writer, citizens);
        } catch (IOException ioe) {
            throw new IllegalStateException("File írási hiba!", ioe);
        }
    }

    private void writeDataLines(BufferedWriter writer, List<Citizen> citizens) throws IOException {
        LocalTime time = START_VACCINATION_TIME;
        for (Citizen citizen : citizens) {
            writer.write(time.toString() + ";" + citizen.getName() + ";" + citizen.getZip() + ";"
                    + citizen.getBirth() + ";" + citizen.getEmail() + ";" + citizen.getTaj() + "\n");
            time = time.plusMinutes(NEXT_VACCINATION_TIME);
        }
    }

}