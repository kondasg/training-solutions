package exceptionmulticatch.converter;

public class AnswerStat {

    private final BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public int answerTruePercent(String answers) {
        boolean[] result = binaryStringConverter.binaryStringToBooleanArray(answers);
        double numTrue = 0;
        for (boolean item: result) {
            if (item) {
                numTrue++;
            }
        }
        double a = (numTrue / result.length) * 100;
        return (int)a;
    }

    public boolean[] convert(String s) {
        try {
            return binaryStringConverter.binaryStringToBooleanArray(s);
        }
        catch (NullPointerException | IllegalArgumentException e) {
            throw new InvalidBinaryStringException(e);
        }
    }
}
