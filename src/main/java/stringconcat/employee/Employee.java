package stringconcat.employee;

public class Employee {
    private final String name;
    private final String job;
    private final int salary;

    public Employee(String name, String job, int salary) {
        if ( name.equals("") ) throw new IllegalArgumentException("Name must not be empty.");
        if ( job == null ) throw new IllegalArgumentException("Job must not be empty.");
        if ( salary < 0 ) throw new IllegalArgumentException("Salary must be positive.");
        if ( salary % 1000 != 0 ) throw new IllegalArgumentException("Salary must be divisible by 1000.");
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - " + job + " - " + salary + " Ft";
    }
}
