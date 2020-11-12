package controlselection.greetings;

public class Greetings {
    public String greet(int hour, int min) {
        String greetText;
        int timeInMinutes = (hour * 60) + min;
        if ( timeInMinutes > (5 * 60) && timeInMinutes <= (9 * 60) ) greetText = "jó reggelt";
        else if ( timeInMinutes > (9 * 60)  && timeInMinutes <= (18 * 60) + 30 ) greetText = "jó napot";
        else if ( timeInMinutes > (18 * 60) + 30 && timeInMinutes <= (20 * 60) ) greetText = "jó estét";
        else greetText = "jó éjt";

        return greetText;
    }
}
