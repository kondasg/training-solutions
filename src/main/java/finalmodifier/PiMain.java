package finalmodifier;

public class PiMain {
    public static void main(String[] args) {
        CircleCalculator circleCalculator = new CircleCalculator();
        CylinderCalculator cylinderCalculator = new CylinderCalculator();

        System.out.println("Pi: " + CircleCalculator.PI);
        System.out.println("5 sugarú kör kerülete: " + circleCalculator.calculatePerimeter(5));
        System.out.println("3 sugarú kör területe: " + circleCalculator.calculateArea(3));

        System.out.println("A henger térfogata (r:5, h:7): " + cylinderCalculator.calculateVolume(5,7));
        System.out.println("A henger felszíne (r:2, h:3): " + cylinderCalculator.calculateSurfaceArea(2,3));
    }
}
