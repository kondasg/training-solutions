package debug;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private final List<Employee> employee;

    public Company(List<Employee> employee) {
        this.employee = employee;
    }

    public void addEmployee(Employee e) {
        employee.add(e);
    }

    public Employee findEmployeeByName(String s) {
        for (Employee e: employee) {
            if (e.getName().equals(s)) return e;
        }
        return null;
    }

    public List<String> listEmployeeNames() {
        List<String> employees = new ArrayList<>();
        for (Employee e: employee) {
            employees.add(e.getName());
        }
        return employees;
    }

}
