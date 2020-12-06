package methodvarargs.examstats;

public class ExamStats {

    int maxPoints;

    public ExamStats(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getNumberOfTopGrades(int limitInPercent, int... results) {
        isZeroResultLength(results);
        int topGrades = 0;
        for (int result: results) {
            if ((((double) result / maxPoints) * 100) > limitInPercent) {
                topGrades++;
            }
        }
        return topGrades;
    }

    public boolean hasAnyFailed(int limitInPercent, int... results) {
        isZeroResultLength(results);
        for (int result: results) {
            if ((((double) result / maxPoints) * 100) < limitInPercent) {
                return true;
            }
        }
        return false;
    }

    public void isZeroResultLength(int[] results) {
        if (results == null || results.length == 0) {
            throw new IllegalArgumentException("Number of results must not be empty!");
        }
    }
}
