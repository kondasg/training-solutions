package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {
        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;

        message += 444;

        boolean b = message.equals("Hello John Doe");
        boolean c = message.equals("Hello John Doe444");

        //System.out.println(c);

        String s1 = "";
        String s2 = "";
        String s3 = s1 + s2;
        System.out.println("s1+s2: " + s3);
        System.out.println("s1+s2 length: " + s3.length());

        String s10 = "Abcde";
        System.out.println(s10 + " string hossza: " + s10.length());
        System.out.println("első char: " + s10.charAt(0) + ", harmadik char: " +s10.charAt(2) );
        System.out.println("Az elsőtől a harmadik karakterig tartó részlete: " + s10.substring(0,3));

    }
}
