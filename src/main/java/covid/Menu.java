package covid;

public class Menu {

    private final int id;
    private final String name;

    public Menu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdAndName() {
        return id + ". " + name;
    }
}
