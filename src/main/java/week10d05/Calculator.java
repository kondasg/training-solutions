package week10d05;

import java.util.*;

public class Calculator {

    public void findMinSum(int[] arr) {
        if (arr == null || arr.length < 4) {
            throw new IllegalArgumentException("Array is must min 4");
        }
        int sum = 0;
        Arrays.sort(arr);
        for (int i = 0; i < 4; i++) {
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
        for (int i = 0; i < 4; i++) {
            min += arr[i];
            max += arr[arr.length - i - 1];
        }
        System.out.println(min + ", " + max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem a tömb elemeit (ha nincs több elem akkor nyomj egy ENTERT-t): ");
        int count = 1;
        String input;
        List<String> arr = new ArrayList<>();
        do {
            System.out.print("Kérem a(z) " + count + ". számot: ");
            input = scanner.nextLine();
            arr.add(input);
            count++;
        } while (!input.isBlank());
        arr.remove(arr.size() - 1);
        int[] arr2 = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arr2[i] = Integer.parseInt(arr.get(i));
        }
        new Calculator().findMinMaxSum(arr2);
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