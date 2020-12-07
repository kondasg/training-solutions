package defaultconstructor.date;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day) {
        if (!isCorrect(year, month, day)) {
            throw new IllegalArgumentException("One or more given parameter cannot be applied! " + year + ", " + month + ", " + day);
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    private boolean isCorrect(int year, int month, int day) {
        if (year <= 1900) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        return calculateMonthLength(year, month) == day;
    }

    private boolean isLeapYear(int year) {
        return (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0));
    }

    private int calculateMonthLength(int year, int month) {
        int day = 0;
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> day = 31;
            case 4, 6, 9, 11 -> day = 30;
            case 2 -> {
                if (isLeapYear(year)) {
                    day = 29;
                } else {
                    day = 28;
                }
            }
        }
        return day;
    }
}
