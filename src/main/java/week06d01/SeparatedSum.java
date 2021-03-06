package week06d01;

import java.util.Scanner;

public class SeparatedSum {

    public ReturnSum sum(String s) {
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
        return new ReturnSum(sumPositive, sumNegative);
    }

}

/*
 Írj egy week06d01.SeparatedSum.sum(String s) metódust, mely kap egy String-et,
 melyben lebegőpontos számok szerepelnek pontosvesszővel elválasztva.
 A számoknál vessző a tizedeselválasztó. Ezt szétszedi, és összeadja külön a pozitív és külön a negatív számokat.
 Mivel térnél vissza ebből a metódusból? Tesztesetet el ne felejtsd!
*/
