package week06d01;

import java.util.Scanner;

public class SeparatedSum {

    public String sum(String s) {
        Scanner scanner = new Scanner(s.replace(",", ".")).useDelimiter(";");
        double sumPositive = 0.0;
        double sumNegative = 0.0;
        while (scanner.hasNext()) {
            double item = Double.parseDouble(scanner.next());
            if (item > 0) {
                sumPositive += item;
            }
            if (item < 0) {
                sumNegative += item;
            }
        }
        return String.format("%.2f;%.2f", sumPositive, sumNegative).replace(".", ",");
    }

}
