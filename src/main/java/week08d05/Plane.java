package week08d05;

import java.io.*;

public class Plane {

    public int longestOcean(InputStreamReader reader) {
        int max = 0;
        try {
            int input;
            int counter = 0;
            while ((input = reader.read()) != -1) {
                if (input == 48) { // input == '0'
                    counter++;
                } else {
                    if (max < counter) {
                        max = counter;
                    }
                    counter = 0;
                }
            }
        } catch (IOException e) {
            System.out.println("IO Error");
        }
        return max;
    }

    public static void main(String[] args) {
        try (InputStreamReader reader = new InputStreamReader(Plane.class.getResourceAsStream("map.txt"))) {
            System.out.println(new Plane().longestOcean(reader));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }

    }
}
