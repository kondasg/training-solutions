package exceptionclass.course;

public class InvalidTimeException extends RuntimeException {

    public InvalidTimeException(String s) {
        super(s);
    }
}
