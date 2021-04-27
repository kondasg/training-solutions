package covid;

import java.time.LocalDate;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Validation implements Constants {

    public boolean isVlalidMenuItem(String selectedMenu, TreeMap<Integer, Menu> menuItems) {
        try {
            return menuItems.containsKey(Integer.parseInt(selectedMenu));
        } catch (NumberFormatException ne) {
            return false;
        }
    }

    public boolean isVlalidName(String name) {
        return name != null && name.trim().length() >= 5;
    }

    public boolean isVlalidZip(String zip) {
        Pattern pattern = Pattern.compile("[1-9][0-9]{3}");
        return zip != null && pattern.matcher(zip).matches();
    }

    public boolean isVlalidBirth(String birth) {
        Pattern pattern = Pattern.compile("[0-9]{4}-[0-1][0-9]-[0-3][0-9]");
        if (birth == null || !pattern.matcher(birth).matches()) {
            return false;
        }
        String[] splittedBirthDate = birth.split("-");
        int year = Integer.parseInt(splittedBirthDate[0]);
        int month = Integer.parseInt(splittedBirthDate[1]);
        int day = Integer.parseInt(splittedBirthDate[2]);
        return month >= 1 && month <= 12
                && day >= 1 && day <= calculateMonthLength(year, month)
                && !LocalDate.of(year + MIN_AGE, month, day).isAfter(LocalDate.now())
                && !LocalDate.of(year + MAX_AGE, month, day).isBefore(LocalDate.now());
    }

    private int calculateMonthLength(int year, int month) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            case 4, 6, 9, 11 -> {
                return 30;
            }
            default -> {
                if (isLeapYear(year)) {
                    return 29;
                } else {
                    return 28;
                }
            }
        }
    }

    private boolean isLeapYear(int year) {
        return (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0));
    }

    public boolean isVlalidEmail(String email) {
        Pattern pattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$");
        return email != null && pattern.matcher(email.toLowerCase()).matches();
    }

    public boolean isVlalidEmailRe(String email, String emailRe) {
        return emailRe != null && emailRe.equals(email);
    }

    public boolean isVlalidTaj(String taj) {
        Pattern pattern = Pattern.compile("[0-9]{9}");
        return taj != null && pattern.matcher(taj).matches() && cdvCheckTaj(taj);
    }

    private boolean cdvCheckTaj(String taj) {
        // A TAJ szám első nyolc számjegyéből a páratlan helyen állókat hárommal,
        // a páros helyen állókat héttel szorozzuk, és a szorzatokat összeadjuk.
        // Az összeget tízzel elosztva a maradékot tekintjük a kilencedik, azaz CDV kódnak.
        int sumEven = 0, sumOdd = 0;
        for (int i = 1; i <= 8; i++) {
            try {
                int num = Integer.parseInt(taj.substring(i - 1, i));
                if (i % 2 == 0) {
                    sumEven += num * 7;
                } else {
                    sumOdd += num * 3;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return (sumOdd + sumEven) % 10 == Integer.parseInt(taj.substring(8, 9));
    }

    public boolean isVlalidDateTime(String dateTime) {
        Pattern pattern = Pattern.compile("[0-9]{4}-[0-1][0-9]-[0-3][0-9] [0-2][0-9]:[0-5][0-9]");
        return dateTime != null && pattern.matcher(dateTime).matches();
    }
}
