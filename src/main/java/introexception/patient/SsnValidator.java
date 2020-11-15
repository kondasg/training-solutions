package introexception.patient;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {
        if (ssn.length() == 9) {
            int oddSum = 0;
            int evenSum = 0;

            for (int odd = 1; odd < 9; odd+=2) {
                oddSum += Integer.parseInt(ssn.substring(odd - 1, odd));
            }
            for (int even = 2; even < 9; even+=2) {
                evenSum += Integer.parseInt(ssn.substring(even - 1, even));
            }
            int c = (oddSum * 3 + evenSum * 7) % 10;
            return c == Integer.parseInt(ssn.substring(8, 9));
        }
        return false;
    }
}
