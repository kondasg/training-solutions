package localvariables;

public class DistanceMain {
    public static void main(String[] args) {
        Distance distance = new Distance(3.14, false);

        System.out.println("Távolság: " + distance.getDistanceInKm() + " km, pontosság: " + distance.isExact());

        int i = (int)distance.getDistanceInKm();
        System.out.println(i);
    }
}
