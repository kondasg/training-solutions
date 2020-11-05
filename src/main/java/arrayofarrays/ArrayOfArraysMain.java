package arrayofarrays;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size) {
        int[][] m = new int[size][size];

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                m[i - 1][j - 1] = i * j;
            }
        }
        return m;
    }

    public void printArrayOfArrays(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public int[][] triangularMatrix(int size) {
        int[][] t = new int[size][];

        for (int i = 0; i < size; i++) {
            t[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                t[i][j] = i;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.multiplicationTable(4));
        System.out.println();
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.triangularMatrix(4));
    }
}
