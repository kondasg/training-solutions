package introconstructors;

import java.time.LocalDateTime;

public class Task {

    String title;
    String description;
    LocalDateTime startDateTime;
    int duration;

    public Task(String title, String description, LocalDateTime startDateTime, int duration) {
        this.title = title;
        this.description = description;
        this.startDateTime = startDateTime;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void start() {
        this.startDateTime = LocalDateTime.now();
    }

    public static void main(String[] args) {
        Task task = new Task("Title", "Descripton", null, 10);

        System.out.println(task.toString());

        task.start();

        System.out.println(task.toString());
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDateTime=" + startDateTime +
                ", duration=" + duration +
                '}';
    }
}
