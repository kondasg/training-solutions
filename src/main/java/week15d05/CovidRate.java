package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.time.LocalDate;
import java.util.*;

public class CovidRate {

    private static final String CSV_SEPARATOR = ",";

    public void readLines(BufferedReader reader) throws IOException {
        String line;
        List<DailyDataOfCovid> data = new ArrayList<>();
        Map<String, Countries> countries = new HashMap<>();
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            readFileAndFillData(line, data, countries);
        }
        sumCasesAndDeath(data, countries);

        Map<String, Countries> sortedMap = sortByCasesPerPopulationRate(countries);

        int count = 0;

        for (Map.Entry<String, Countries> entry : sortedMap.entrySet()) {
            if (count >= 3) break;
            if (entry.getValue().getPopData2019() > 0) {
                System.out.println(entry.getValue().getName());
                count++;
            }
        }
    }

    private Map<String, Countries> sortByCasesPerPopulationRate(Map<String, Countries> countries) {
        List<Map.Entry<String, Countries>> list = new LinkedList<>(countries.entrySet());

        list.sort(new Comparator<>() {
            public int compare(Map.Entry<String, Countries> o1, Map.Entry<String, Countries> o2) {
                return Double.compare(
                        o2.getValue().getCasesPerPopulationRate(), o1.getValue().getCasesPerPopulationRate());
            }
        });

        Map<String, Countries> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Countries> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    private void sumCasesAndDeath(List<DailyDataOfCovid> data, Map<String, Countries> countries) {
        for (DailyDataOfCovid dailyDataOfCovid : data) {
            countries.put(dailyDataOfCovid.getGeoId(),
                    countries.get(dailyDataOfCovid.getGeoId())
                            .incCasesAndDeaths(dailyDataOfCovid.getCases(), dailyDataOfCovid.getDeaths()));
        }
    }

    private void readFileAndFillData(String line, List<DailyDataOfCovid> data, Map<String, Countries> countries) {
        String[] splittedLines;
        if (line.contains("\"")) {
            splittedLines = containsQuoteMarkCsv(line);
        } else {
            splittedLines = line.split(CSV_SEPARATOR);
        }
        fillCountries(countries, splittedLines);
        fillData(data, splittedLines);
    }

    private String[] containsQuoteMarkCsv(String line) {
        // ez jelen CSV-nél használható a " kiszűrésére, de ha az összes oszlop "" között van, akkor gond van
        String[] splittedLines;
        line = line.replace(",\"", "#&@&#");
        line = line.replace("\",", "#&@&#");
        String[] s = line.split("#&@&#");
        StringBuilder newLine = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if (i % 2 == 0) {
                s[i] = s[i].replace(",", ";");
            }
            if (i > 0) newLine.append(";");
            newLine.append(s[i]);
        }
        splittedLines = newLine.toString().split(";");
        return splittedLines;
    }

    private void fillCountries(Map<String, Countries> countries, String[] splittedLines) {
        int popData2019 = 0;
        if (!splittedLines[9].isBlank()) { // néhol üres a popData2019 oszlop
            popData2019 = Integer.parseInt(splittedLines[9]);
        }
        countries.put(splittedLines[7], new Countries(
                splittedLines[7],
                splittedLines[6],
                splittedLines[8],
                popData2019,
                splittedLines[10]
        ));
    }

    private void fillData(List<DailyDataOfCovid> data, String[] splittedLines) {
        double cumNum = 0;
        if (splittedLines.length > 11) { // néhol üres az utolsó oszlop és split nem teszi be String[]-be
            cumNum = Double.parseDouble(splittedLines[11]);
        }
        data.add(new DailyDataOfCovid(
                LocalDate.of(Integer.parseInt(splittedLines[3]),
                        Integer.parseInt(splittedLines[2]), Integer.parseInt(splittedLines[1])),
                Integer.parseInt(splittedLines[4]),
                Integer.parseInt(splittedLines[5]),
                splittedLines[7],
                cumNum
        ));
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(CovidRate.class.getResourceAsStream("data.csv")))) {
            new CovidRate().readLines(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }
}

// Senior
//
// Letölthetőek a COVID adatok a https://opendata.ecdc.europa.eu/covid19/casedistribution/csv/data.csv címről.
// Összegezd országonként az esetszámokat, és add vissza azt a három országot, ahol az összes esetszám populációra arányosítva a legnagyobb.
