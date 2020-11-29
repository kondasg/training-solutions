package intromethods;

public class Todo {
    String caption;
    boolean finished;

    public Todo(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public boolean isFinished() {
        return finished;
    }

    public void finish() {
        this.finished = true;
    }
}
