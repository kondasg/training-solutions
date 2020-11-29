package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption) {
        todos.add(new Todo(caption));
    }

    public void finishTodos(String caption) {
        for (Todo todo: todos) {
            if (todo.getCaption().equals(caption)) {
                todo.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish) {
        for (String s: todosToFinish) {
            finishTodos(s);
        }
    }

    public List<String> todosToFinish() {
        List<String> notFinish = new ArrayList<>();
        for (Todo todo: todos) {
            if (!todo.isFinished()) {
                notFinish.add(todo.getCaption());
            }

        }
        return notFinish;
    }

    public int numberOfFinishedTodos() {
        int finish = 0;
        for (Todo todo: todos) {
           if  (todo.isFinished()) {
               finish++;
           }
        }
        return finish;
    }

    @Override
    public String toString() {
        String s = "";
        for (Todo todo: todos) {
            s += todo.toString() + "\n";
        }
        return s;
    }
}
