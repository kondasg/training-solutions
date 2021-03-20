package week15d05;

public class Countries {

    private final String geoId;
    private final String name;
    private final String code;
    private final int popData2019;
    private final String continent;
    private int cases = 0;
    private int deaths = 0;

    public Countries(String geoId, String name, String code, int popData2019, String continent) {
        this.geoId = geoId;
        this.name = name;
        this.code = code;
        this.popData2019 = popData2019;
        this.continent = continent;
    }

    public String getGeoId() {
        return geoId;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getPopData2019() {
        return popData2019;
    }

    public String getContinent() {
        return continent;
    }

    public int getCases() {
        return cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void incCases(int cases) {
        this.cases += cases;
    }

    public void incDeaths(int deaths) {
        this.deaths += deaths;
    }

    public Countries incCasesAndDeaths(int cases, int deaths) {
        incCases(cases);
        incDeaths(deaths);
        return this;
    }

    public double getCasesPerPopulationRate() {
        return (double) cases / popData2019;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "geoId='" + geoId + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", popData2019=" + popData2019 +
                ", continent='" + continent + '\'' +
                ", cases=" + cases +
                ", deaths=" + deaths +
                '}';
    }
}
