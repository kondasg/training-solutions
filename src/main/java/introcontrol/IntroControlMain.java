package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introControl = new IntroControl();

        System.out.println(introControl.substractTenIfGreaterThanTen(123));
        System.out.println(introControl.substractTenIfGreaterThanTen(10));
        System.out.println(introControl.substractTenIfGreaterThanTen(5));

        System.out.println();

        System.out.println(introControl.describeNumber(0));
        System.out.println(introControl.describeNumber(12));

        System.out.println();

        System.out.println(introControl.greetingToJoe("Joe"));
        System.out.println(introControl.greetingToJoe("nem Joe"));

        System.out.println();
        System.out.println(introControl.calculateBonus(999_999));
        System.out.println(introControl.calculateBonus(1_000_000));
        System.out.println(introControl.calculateBonus(1_999_999));

        System.out.println();
        System.out.println(introControl.calculateConsumption(9999,1));

        System.out.println();
        introControl.printNumbers(24);

        System.out.println();
        introControl.printNumbersBetween(1, 11);

        System.out.println();
        introControl.printNumbersBetweenAnyDirection(34, 15);

        System.out.println();
        introControl.printOddNumbers(10);
    }
}
