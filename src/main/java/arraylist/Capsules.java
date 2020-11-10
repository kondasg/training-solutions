package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {

    private final List<String> colors = new ArrayList<>();

    public List<String> getColors() {
        return colors;
    }

    public void addLast(String s) {
        colors.add(s);
    }

    public void addFirst(String s) {
        colors.add(0, s);
    }

    public void removeFirst() {
        colors.remove(0);
    }

    public void removeLast() {
        colors.remove(colors.size()-1);
    }

    public static void main(String[] args) {
        Capsules capsules = new Capsules();

        capsules.addFirst("1");
        capsules.addFirst("2");
        capsules.addLast("3");
        capsules.addLast("4");
        capsules.addFirst("5");

        System.out.println(capsules.getColors());

        capsules.removeFirst();
        capsules.removeFirst();
        capsules.removeLast();

        System.out.println(capsules.getColors());
    }
}
