package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String s) {
        if (s == null)
            throw new NullPointerException("binaryString null");
        boolean[] result = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                result[i] = false;
            }
            else if (c == '1') {
                result[i] = true;
            }
            else {
                throw new IllegalArgumentException("binaryString not valid");
            }
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] b) {
        if (b == null)
            throw new NullPointerException("booleans null");
        if (b.length == 0)
            throw new IllegalArgumentException("booleans size 0");
        StringBuilder result = new StringBuilder();
        for (boolean value : b) {
            if (value) {
                result.append("1");
            }
            else {
                result.append("0");
            }
        }
        return result.toString();
    }
}
