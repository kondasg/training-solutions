package week15d04;

import week15d05.CovidRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CovidStat {

    private final List<CovidCaseByWeek> cases = new ArrayList<>();

    public List<CovidCaseByWeek> getCases() {
        return new ArrayList<>(cases);
    }

    public void readFromFile(BufferedReader br) {
        try {
            String line;
            br.readLine(); // csv fejléc dobás
            while ((line = br.readLine()) != null) {
                if (line.contains(",Hungary,")) {
                    cases.add(processLine(line));
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("");
        }
    }

    private CovidCaseByWeek processLine(String line) {
        String[] temp = line.split(",");
        int numberOfCases = Integer.parseInt(temp[2]);
        return new CovidCaseByWeek(temp[1], numberOfCases);
    }

    public List<String> findFirstThree() {
        List<CovidCaseByWeek> sorted = new ArrayList<>(cases);
        Collections.sort(sorted);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(sorted.get(i).getWeek());
        }
        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(CovidStat.class.getResourceAsStream("data.csv")))) {
            CovidStat covidStat = new CovidStat();
            covidStat.readFromFile(br);
            System.out.println(covidStat.findFirstThree());
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file");
        }
    }
}
