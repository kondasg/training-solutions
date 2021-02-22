package exceptions.faults;

public enum ProcessingResult {

    WORD_COUNT_ERROR (2), // azaz a sor nem bontható 3 db , karakterrel elválaszható részre.
    VALUE_ERROR (4), // azaz a második rész nem double szám.
    DATE_ERROR (8), // azaz a harmadik rész nem yyyy.MM.dd. alakú dátum
    VALUE_AND_DATE_ERROR (12); //azaz egyszerre van VALUE_ERROR és DATE_ERROR is.

    int code;

    ProcessingResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
