package arrayofarrays;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size) {
        int[][] m = new int[size][size];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                m[i - 1][j - 1] = i*j;
            }
        }
        return m;
    }


    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        arrayOfArraysMain.multiplicationTable(4);
    }
}
