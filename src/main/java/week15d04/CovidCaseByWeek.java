package week15d04;

public class CovidCaseByWeek implements Comparable<CovidCaseByWeek> {

    private final String week;
    private final int cases;

    public CovidCaseByWeek(String week, int cases) {
        this.week = week;
        this.cases = cases;
    }

    public String getWeek() {
        return week;
    }

    public int getCases() {
        return cases;
    }

    @Override
    public String toString() {
        return "CovidCasesByWeek{" +
                "week='" + week + '\'' +
                ", cases='" + cases + '\'' +
                '}';
    }

    @Override
    public int compareTo(CovidCaseByWeek o) {
        return o.cases - this.cases;
    }
}
