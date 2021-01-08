package week10d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calculator {

    public void findMinSum(int[] arr) {
        if (arr == null || arr.length < 4) {
            throw new IllegalArgumentException("Array is must min 4");
        }
        int sum = 0;
        Arrays.sort(arr);
        for (int i=0; i<4; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }

    public void findMinMaxSum(int[] arr) {
        if (arr == null || arr.length < 4) {
            throw new IllegalArgumentException("Array is must min 4");
        }
        int min = 0;
        int max = 0;
        Arrays.sort(arr);
        for (int i=0; i<4; i++) {
            min += arr[i];
        }
        int l = arr.length;
        for (int j=l; j>l-4; j--) {
            max += arr[j-1];
        }
        System.out.println(min + ", " + max);
    }

    public static void main(String[] args) {

    }
}

// Mai junior-mid-level feladat:
// Készítsünk egy Calculator nevű osztályt, melynek van egy findMinSum(int[] arr) metódusa.
// A metódus feladata, hogy kiírja a legkisebb összegeket 4 számból, amiket lehetséges összerakni az arr tömb elemeiből.
// Példa: ha az arr tartalma [1, 3, 5, 7, 9], akkor a minimum összeg 1+3+5+7=16.
//
// Mai senior feladat:
// Készítsünk egy Calculator nevű osztályt, melynek van egy findMinMaxSum(int[] arr) metódusa.
// A metódus feladata, hogy kiírja a legnagyobb és a legkisebb összegeket 4 számból,
// amiket lehetséges összerakni az arr tömb elemeiből.
// Példa: ha az arr tartalma [1, 3, 5, 7, 9], akkor a minimum összeg 1+3+5+7=16 , a maximum összeg 3+5+7+9=24.
// A Calculator osztály tartalmazzon egy main metódust is, amely a konzolról olvassa be a számokat és azokból készít tömböt,
// amivel meghívja a findMinMaxSum metódust.