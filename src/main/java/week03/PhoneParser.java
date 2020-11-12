package week03;

public class PhoneParser {

    public Phone parse(String s) {
        String s1 = s.substring(0,1);
        String s2 = s.substring(3);
        return new Phone(s1, s2);
    }

    public static void main(String[] args) {
        PhoneParser phoneParser = new PhoneParser();

        System.out.println(phoneParser.parse("30-1234567"));
    }
}
