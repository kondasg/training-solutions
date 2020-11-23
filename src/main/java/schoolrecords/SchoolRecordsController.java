package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    private static boolean exit = false;
    private ClassRecords classRecords;
    private final List<Tutor> tutors = new ArrayList<>();
    private final List<Subject> subjects = new ArrayList<>();

    List<String> menuItems = List.of(
            "Diákok nevének listázása", // 1
            "Diák név alapján keresése", // 2
            "Diák létrehozása",
            "Diák név alapján törlése",
            "Diák feleltetése",
            "Osztályátlag kiszámolása",
            "Tantárgyi átlag kiszámolása",
            "Diákok átlagának megjelenítése",
            "Diák átlagának kiírása",
            "Diák tantárgyhoz tartozó átlagának kiírása",
            "Kilépés"); // 11

    public void initSchool() {
        classRecords = new ClassRecords("Fourth Grade A", new Random());
        for (Subjects subject : Subjects.values()) {
            subjects.add(new Subject(subject.getName()));
        }
        for (Tutors tutor : Tutors.values()) {
            List<Subject> tutorSubjects = new ArrayList<>();
            for (Subjects subject : tutor.getSubjects()) {
                tutorSubjects.add(new Subject(subject.getName()));
            }
            tutors.add(new Tutor(tutor.getName(), tutorSubjects));
        }
    }

    public void printMenu() {
        System.out.println("\nMENÜ");
        int i = 0;
        for (String item: menuItems) {
            System.out.println(++i + ". " + item);
        }
    }

    public void runMenu() {
        printMenu();

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nKérem válasszon a menüpontok közül: ");
        int numberOfMenu = Integer.parseInt(scanner.nextLine());

        if ( numberOfMenu > 0 && numberOfMenu <= menuItems.size() ) {
            System.out.println("\n["+ numberOfMenu + ". " + menuItems.get(numberOfMenu - 1) + "]");
            if (numberOfMenu == 1)
                System.out.println(classRecords.listStudentNames());
            if (numberOfMenu == 2) {
                System.out.print("Kérem a nevet: ");
                System.out.println(classRecords.findStudentByName(scanner.nextLine()).getName());
            }
            if (numberOfMenu == 3) {
                System.out.print("Kérem a nevet: ");
                classRecords.addStudent(new Student(scanner.nextLine()));
            }
            if (numberOfMenu == 4) {
                System.out.print("Kérem a nevet: ");
                classRecords.removeStudent(classRecords.findStudentByName(scanner.nextLine()));
            }
            if (numberOfMenu == 5) {
                Student luckyGuy = classRecords.repetition();
                System.out.println(luckyGuy.getName() + " feleltése:");
                System.out.print("Kérem az érdemjegyet " + Arrays.toString(MarkType.values()) + ": ");
                String mark = scanner.nextLine();
                System.out.print("Kérem a tárgy nevét (" + toStringOfSubjects() + "): ");
                String subjectName = scanner.nextLine();
                System.out.print("Kérem az oktató nevét (" + toStringOfTutors(subjectName) +  "): ");
                String tutorName = scanner.nextLine();

                luckyGuy.grading(new Mark(mark, new Subject(subjectName), getTutor(tutorName) ));
                classRecords.addStudent(luckyGuy);
            }
            if (numberOfMenu == 6)
                System.out.println(classRecords.calculateClassAverage());
            if (numberOfMenu == 7) {
                for (Subject item: subjects) {
                    System.out.println(item.getSubjectName() + ": " + classRecords.calculateClassAverageBySubject(new Subject(item.getSubjectName())));
                }
            }
            if (numberOfMenu == 8) {
                for (StudyResultByName item: classRecords.listStudyResults()) {
                    System.out.println(item.getStudentName() + ": " + item.getStudyAverage());
                }
            }
            if (numberOfMenu == 9) {
                System.out.print("Kérem a nevet: ");
                System.out.println(classRecords.findStudentByName(scanner.nextLine()).calculateAverage());
            }
            if (numberOfMenu == 10) {
                System.out.print("Kérem a nevet: ");
                String name = scanner.nextLine();
                System.out.print("Kérem a tárgy nevét (" + toStringOfSubjects() + "): ");
                String subjectName = scanner.nextLine();
                System.out.println(classRecords.findStudentByName(name).calculateSubjectAverage(new Subject(subjectName)));
            }
            if (numberOfMenu == 11) exit = true;
        }

    }

    public Tutor getTutor(String name) {
        for (Tutor tutor: tutors) {
            if (tutor.getName().equals(name)) return tutor;
        }
        return null;
    }

    public String toStringOfSubjects() {
        StringBuilder sb = new StringBuilder();
        int separator = 0;
        for (Subject item: subjects) {
            if (separator != 0) sb.append(", ");
            sb.append(item.getSubjectName());
            separator++;
        }
        return sb.toString();
    }

    public String toStringOfTutors(String subjectName) {
        StringBuilder sb = new StringBuilder();
        int separator = 0;
        for (Tutor item: tutors) {
            if (separator != 0) sb.append(", ");
            sb.append(item.getName());
            separator++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();

        schoolRecordsController.initSchool();
        do {
            schoolRecordsController.runMenu();
        } while (!exit);

    }
}
