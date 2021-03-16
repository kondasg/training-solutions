package week12d05;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFilter {

    public List<Employee> countSeniorDevs(List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSkillLevel() >= 3 && employee.getSkills().contains("programming")) {
                result.add(employee);
            }
        }
        return result;
    }
}

// Senior
//
// Adott az alábbi osztály:
//
// public class Employee {
//    private int age;
//    private int skillLevel;
//    private String name;
//    private List<String> skills;
// }
//
// Készítsetek az EmployeeFilter osztályba egy List<Employee> countSeniorDevs(List<Employee> employees) metódust,
// mely a megadott employees-ből kiválogatja a senior (ahol a skill level nagyobb, vagy egyenlő, mint 3) fejlesztőket!
// A fejlesztők rendelkeznek a programming skill-lel!