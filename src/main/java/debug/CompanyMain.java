package debug;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {

    public static void main(String[] args) {
        Employee e1 = new Employee("John", 1990);
        Employee e2 = new Employee("Jack", 1980);
        Employee e3 = new Employee("Jane", 1985);

        List<Employee> e = new ArrayList<>();
        e.add(e1);
        e.add(e2);
        e.add(e3);

        Company company = new Company(e);

        System.out.println(e1.getName());
        System.out.println(e2.getYearOfBirth());

        System.out.println(company.listEmployeeNames());

        System.out.println(company.findEmployeeByName("Jacka"));
    }
}
