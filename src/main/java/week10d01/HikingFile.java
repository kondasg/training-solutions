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
                elevation.add(Double.parseDouble(data[2].trim()));
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

// Túrázás közben egy GPS eszköz rögzíti a pontokat. Eltárolja a GPS koordinátákat, valamint a magasságot (mindegyik lebegőpontos érték).
// Ezt egy fájlba tárolja, melynek formátuma:
//  47.497913, 19.040236, 400
//  47.497912, 19.040232, 420
//  47.497916, 19.040236, 410
// Írj a week10d01.HikingFile osztályba egy getPlusElevation() metódust, mely kap egy InputStream-et, és visszaadja
// külön az ereszkedések, és külön az emelkedések összegét. Azaz pl. 10,20,15,18 esetén az emelkedés 13, ugyanis (20 - 10) + (18 - 15).
// A 20 méterről 15 méterre ereszkedést pedig 5.