package week03;

public class Operation {
    private final int leftOperand;
    private final int rightOperand;

    public Operation(String s) {
        String s1 = s.substring(0,s.indexOf("+"));
        String s2 = s.substring(s.indexOf("+")+1);
        this.leftOperand = Integer.parseInt(s1);
        this.rightOperand = Integer.parseInt(s2);
    }

    public int getResult() {
        return leftOperand + rightOperand;
    }

    public static void main(String[] args) {
        Operation operation = new Operation("10+11");
        System.out.println(operation.getResult());
    }
}
