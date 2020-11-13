package controlselection.week;

public class DayOfWeeks {
    public String whichDay(String day) {
        return switch (day.toLowerCase()) {
            case "hétfő" -> "hét eleje";
            case "kedd", "szerda", "csütörtök" -> "hét közepe";
            case "péntek" -> "majdnem hétvége";
            case "szombat", "vasárnap" -> "hét vége";
            default -> throw new IllegalArgumentException("Invalid day: " + day);
        };
    }
}
