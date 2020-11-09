package primitivetypes;

public class PrimitiveTypesMain {
    public static void main(String[] args) {
        int n = 75;

        PrimitiveTypes primitiveTypes = new PrimitiveTypes();

        System.out.println(primitiveTypes.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n));

        // System.out.println(new Integer(1) + new Integer(2));
    }
}
