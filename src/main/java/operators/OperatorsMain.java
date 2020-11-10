package operators;

public class OperatorsMain {
    public static void main(String[] args) {
        Operators operators = new Operators();

        System.out.println(operators.isEven(2));

        System.out.println(operators.multiplyByPowerOfTwo(5, 5));

        System.out.println();

        //System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        int i = -1;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        //int j = Integer.parseInt(s, 2);
        int j = Long.valueOf(s, 2).intValue();
        System.out.println(j);
        // Miért ad a következő kódrészlet kivételt? s értéke nagyobb mint az Integer tartomány (számábrázolás 32bit)
        // Miért megoldás erre a Long.valueOf(s, 2).intValue() kifejezés használata? Mert nagyonn a Long értelmezési tartománya (számábrázolás  64bit)

        System.out.println();

        System.out.println(0333);
        // oktális 333 az decimális 219
    }
}
