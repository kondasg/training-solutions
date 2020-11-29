package intromethods;

public class Employee {

    String name;
    int hiringYear;
    int salary;

    public Employee(String name, int hiringYear, int salary) {
        this.name = name;
        this.hiringYear = hiringYear;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getHiringYear() {
        return hiringYear;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void raiseSalary(int raise) {
        this.salary += raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", hiringYear=" + hiringYear +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Józsi", 2000, 110000);

        System.out.println(employee);

        employee.setName("Józsi 2");

        System.out.println(employee);

        employee.raiseSalary(25000);

        System.out.println(employee);
    }
}
