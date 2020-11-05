package array;

public class ArrayHandler {
    public boolean contains(int[] source, int itemToFind) {
        for (int s: source) {
            if (s == itemToFind) {
                return true;
            }
        }
        return false;
    }

    public int find(int[] source, int itemToFind) {
        return -1;
    }

    public static void main(String[] args) {
        ArrayHandler arrayHandler = new ArrayHandler();

        int[] numArray = {1, 5, 7 , 4, 11, 25, 9, 44};

        System.out.println(arrayHandler.contains(numArray, 41));
        System.out.println(arrayHandler.contains(numArray, 4));

        System.out.println();

//        System.out.println(arrayHandler.find(numArray, 41));
//        System.out.println(arrayHandler.find(numArray, 4));

    }
}
