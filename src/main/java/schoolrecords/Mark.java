package schoolrecords;

public class Mark {

    private MarkType markType;
    private final Subject subject;
    private final Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        this.markType = markType;
        this.subject = subject;
        this.tutor = tutor;
    }

    public Mark(String markType, Subject subject, Tutor tutor) {
//        this.markType = markType;
        this.subject = subject;
        this.tutor = tutor;
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public String toString() {
        return "";
    }
}
