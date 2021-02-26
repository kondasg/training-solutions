package exam03retake02;

public class Todo {

    private final String text;
    private final int priority;
    private State state;

    public Todo(String text, int priority) {
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Invalid");
        }
        this.text = text;
        this.priority = priority;
        this.state = State.NON_COMPLETED;
    }

    public String getText() {
        return text;
    }

    public State getState() {
        return state;
    }

    public int getPriority() {
        return priority;
    }

    public void complete() {
        state = State.COMPLETED;
    }
}
