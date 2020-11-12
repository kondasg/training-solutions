package week03;

public class PhoneParser {

    public Phone parse(String s) {
        String s1 = s.substring(0,s.indexOf("-"));
        String s2 = s.substring(s.indexOf("-")+1);
        return new Phone(s1, s2);
    }

    public static void main(String[] args) {
/*        PhoneParser phoneParser = new PhoneParser();

        Phone phone = phoneParser.parse("30-1234567");
        System.out.println(phone);

 */
    }
}
