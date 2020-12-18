package week08d05;

import java.io.*;


public class Plane {

    public int longestOcean(String path) {
        int max = 0;
        try (FileInputStream fis = new FileInputStream(path)) {
            int input;
            int counter = 0;
            while ((input = fis.read()) != -1) {
                if (input == 48) { // input == '0'
                    counter++;
                } else {
                    if (max < counter) {
                        max = counter;
                    }
                    counter = 0;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO Error");
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Plane().longestOcean("map.txt"));
    }
}
