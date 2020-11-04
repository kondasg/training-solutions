package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {
    String name;
    LocalDate dateOfBirth;
    LocalDateTime beginEmployment;

    public Employee(String name, int year, int month, int day) {
        this.name = name;
        this.dateOfBirth = LocalDate.of(year,month,day);
        beginEmployment = LocalDateTime.now();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getBeginEmployment() {
        return beginEmployment;
    }
}
