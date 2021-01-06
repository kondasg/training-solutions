package exam02;

public class ArraySelector {

    public String selectEvens(int[] numbers) {
        if (numbers.length == 0) return "";
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                if (i > 0) {
                    result.append(", ");
                }
                result.append(numbers[i]);
            }
        }
        return result.append("]").toString();
    }
}
