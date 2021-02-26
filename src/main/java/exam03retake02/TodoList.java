package exam03retake02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoList {

    List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return new ArrayList<>(todos);
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public int getNumberOfItemsLeft() {
        int nonCompeted = 0;
        for (Todo todo : todos) {
            if (todo.getState().equals(State.NON_COMPLETED)) {
                nonCompeted++;
            }
        }
        return nonCompeted;
    }

    public List<String> getMostImportantTodosText() {
        List<String> mostImportant = new ArrayList<>();
        mostImportant.add(todos.get(0).getText());
        int mostImportantPriority = todos.get(0).getPriority();
        for (int i = 1; i < todos.size(); i++) {
            mostImportantPriority = getMostImportantPriority(mostImportant, mostImportantPriority, i);
        }
        return mostImportant;
    }

    private int getMostImportantPriority(List<String> mostImportant, int mostImportantPriority, int i) {
        if (mostImportantPriority > todos.get(i).getPriority()) {
            mostImportant.clear();
            mostImportant.add(todos.get(i).getText());
            mostImportantPriority = todos.get(i).getPriority();
        } else if (mostImportantPriority == todos.get(i).getPriority()) {
            mostImportant.add(todos.get(i).getText());
        }
        return mostImportantPriority;
    }

    public void deleteCompleted() {
        Iterator<Todo> i = todos.iterator();
        while (i.hasNext()) {
            if (i.next().getState().equals(State.COMPLETED)) {
                i.remove();
            }
        }
    }
}
