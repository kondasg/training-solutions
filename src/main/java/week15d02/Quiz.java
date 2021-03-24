package week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz {

    private final List<Question> questions = new ArrayList<>();

    public List<Question> getQuestions() {
        return questions;
    }

    public void loadFile(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String line2 = reader.readLine();
                String[] splittedLine2 = line2.split(" ");
                questions.add(new Question(line, Integer.parseInt(splittedLine2[0]),
                        Integer.parseInt(splittedLine2[1]), splittedLine2[2]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file", ioe);
        }
    }

    public List<String> questionsOfCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("category is empty");
        }
        List<String> result = new ArrayList<>();
        for (Question question : questions) {
            if (category.equals(question.getCategory())) {
                result.add(question.getQuestion());
            }
        }
        if (result.size() == 0) {
            throw new IllegalArgumentException("no questions found in the category");
        } else {
            return result;
        }
    }

    public Question randomQuestion() {
        return questions.get(new Random().nextInt(questions.size()));
    }

    public Map<String, List<Question>> sortByCategory() {
        Map<String, List<Question>> result = new HashMap<>();
        for (Question question : questions) {
            String category = question.getCategory();
            if (result.containsKey(category)) {
                List<Question> questionList = result.get(category);
                questionList.add(question);
                result.put(category, questionList);
            } else {
                result.put(category, new ArrayList<>(List.of(question)));
            }
        }
        return result;
    }

    public String categoryOfMostPoints() {
        String category = "";
        int maxPoints = Integer.MIN_VALUE;
        for (String key : sortByCategory().keySet()) {
            int categoryPoint = 0;
            for (Question question : sortByCategory().get(key)) {
                categoryPoint += question.getPoint();
            }
            if (categoryPoint > maxPoints) {
                maxPoints = categoryPoint;
                category = key;
            }
        }
        return category;
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Quiz.class.getResourceAsStream("kerdesek.txt")))) {
            quiz.loadFile(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }

        System.out.println("1. Írj egy metódust, melynek paramétere a téma és add vissza, az összes kérdést abban a témában. (Csak a kérdéseket)");
        List<String> task1 = quiz.questionsOfCategory("foldrajz");
        System.out.println(task1.size());
        System.out.println(task1);
        System.out.println();

        System.out.println("2. Írj egy metódust, ami random sorsol ki egy kérdést, és adja vissza annak összes adatát.");
        System.out.println(quiz.randomQuestion());
        System.out.println();

        System.out.println("3. Készíts egy metódust ami rendszerezi a kérdéseket témakörönként. Visszatér egy adatszerkezetben amelyben témánként megtalálható az összes kérdés, összes adata.");
        System.out.println(quiz.sortByCategory());
        System.out.println();

        System.out.println("4. Az előző feladat segítségével határozd meg, hogy melyik téma kérdései érik a legtöbb pontot (összpontszám)!");
        System.out.println(quiz.categoryOfMostPoints());
    }
}
