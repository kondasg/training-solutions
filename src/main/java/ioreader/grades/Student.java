package ioreader.grades;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final String name;
    private final List<Integer> gradeList;

    public Student(String name, List<Integer> gradeList) {
        this.name = name;
        this.gradeList = gradeList;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGradeList() {
        return new ArrayList<>(gradeList);
    }

    public double average() {
        int sum = 0;
        for (int mark : gradeList) {
            sum += mark;
        }
        return (double) sum / gradeList.size();
    }

    public boolean isIncreasing() {
        int prev = gradeList.get(0);
        for (int mark : gradeList) {
            if (prev > mark) {
                return false;
            }
            prev = mark;
        }
        return true;
    }
}
