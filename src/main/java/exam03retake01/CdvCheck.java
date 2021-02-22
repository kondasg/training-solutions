package exam03retake01;

public class CdvCheck {

    public boolean check(String s) {
        if (s.length() != 10) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            try {
                sum += (i + 1) * Integer.parseInt(s.substring(i, i + 1));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return sum % 11 == Integer.parseInt(s.substring(9, 10));
    }
}
