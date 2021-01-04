package week10d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HikingFile {
    
    public Elevation getElevation(String file) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                HikingFile.class.getResourceAsStream(file)))) {
            String line;
            List<Double> elevation = new ArrayList<>();
            while((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                elevation.add(Double.parseDouble(data[2]));
            }
            double prevElevation = elevation.get(0);
            double plus = 0;
            double minus = 0;
            for (double item: elevation) {
                if (prevElevation < item) {
                    plus = Double.sum(plus,item-prevElevation);
                }
                if (prevElevation > item) {
                    minus = Double.sum(minus,item-prevElevation);
                }
                prevElevation = item;
            }

            return new Elevation(plus,Math.abs(minus));
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }

    public static void main(String[] args) {
        System.out.println(new HikingFile().getElevation("gps.txt"));
    }

}
