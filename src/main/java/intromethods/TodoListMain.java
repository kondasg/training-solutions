package intromethods;

import java.lang.reflect.Array;
import java.util.List;

public class TodoListMain {

    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        todoList.addTodo("Feladat 1");
        todoList.addTodo("Feladat 2");
        todoList.addTodo("Feladat 2");
        todoList.addTodo("Feladat 3");
        todoList.addTodo("Feladat 3");
        todoList.addTodo("Feladat 5");
        todoList.addTodo("Feladat 5");
        todoList.addTodo("Feladat 6");

        todoList.finishTodos("Feladat 2");

        System.out.println(todoList.numberOfFinishedTodos());
        System.out.println(todoList.todosToFinish());

        todoList.finishAllTodos(List.of("Feladat 3", "Feladat 5"));

        System.out.println(todoList.numberOfFinishedTodos());
        System.out.println(todoList.todosToFinish());

    }
}
