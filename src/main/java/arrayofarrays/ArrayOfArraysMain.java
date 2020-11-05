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

    public void printArrayOfArrays(int[][] a) {
        for ( int i = 0; i < a.length; i++) {
            for ( int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.multiplicationTable(4));
    }
}
