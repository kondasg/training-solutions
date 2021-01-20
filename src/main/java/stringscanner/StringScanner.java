package stringscanner;

import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intString, String delimiter) {
        if (isEmpty(intString)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        Scanner scanner = new Scanner(intString);
        if (!isEmpty(delimiter)) {
            scanner.useDelimiter(delimiter);
        }

        int sum = 0;
        try {
            while (scanner.hasNext()) {
                String s = scanner.next();
                sum += Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Incorrect parameter string!", e);
        }
        return sum;
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, null);
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        if (word == null || "".equals(word)) {
            throw new IllegalArgumentException("Incorrect parameter string!");
        }
        Scanner scanner = new Scanner(text).useDelimiter("\n");
        StringBuilder result = new StringBuilder();
        int separator = 0;
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.contains(word)) {
                if (separator > 0) {
                    result.append("\n");
                }
                result.append(s);
                separator++;
            }
        }
        return result.toString();
    }

    public boolean isEmpty(String s) {
        return (s == null || "".equals(s.trim()));
    }
}
