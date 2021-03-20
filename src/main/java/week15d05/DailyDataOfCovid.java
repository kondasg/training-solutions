package week15d05;

import java.time.LocalDate;

public class DailyDataOfCovid {

    private final LocalDate date;
    private final int cases;
    private final int deaths;
    private final String geoId;
    private final double cumNum;      // Cumulative_number_for_14_days_of_COVID-19_cases_per_100000

    public DailyDataOfCovid(LocalDate date, int cases, int deaths, String geoId, double cumNum) {
        this.date = date;
        this.cases = cases;
        this.deaths = deaths;
        this.geoId = geoId;
        this.cumNum = cumNum;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCases() {
        return cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public String getGeoId() {
        return geoId;
    }

    public double getCumNum() {
        return cumNum;
    }
}
