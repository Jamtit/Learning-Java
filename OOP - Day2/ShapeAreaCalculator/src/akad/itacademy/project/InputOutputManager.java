package swed.itacademy.project;

import java.util.Scanner;

public class InputOutputManager {

    // Why static everywhere?
    private static int shape;
    private static float data1;
    private static float data2;

    static final Scanner scanner = new Scanner(System.in);

    public static int getShape() {
        return shape;
    }

    public static float getData1() {
        return data1;
    }

    public static float getData2() {
        return data2;
    }

    public static void chooseAShape(){
        System.out.println("Choose a shape: 1 - Square, 2 - Triangle, 3 - Circle");
        shape = scanner.nextInt();
    }

    public static void receiveAdditionalDataOfShape(int shape) throws UnknownShapeException {
        switch (shape){
            case 1:
                System.out.println("This is a Square, please provide value (in cm) for 1 side of it:");
                data1 = scanner.nextFloat();
                break;

            case 2:
                System.out.println("This is a Triangle, please provide values (in cm) for 2 sides of it:");
                data1 = scanner.nextFloat();
                data2 = scanner.nextFloat();
                break;

            case 3:
                System.out.println("This is a Circle, please provide a radius value (in cm) for it:");
                data1 = scanner.nextFloat();
                break;

            default:
                scanner.close();
                throw new UnknownShapeException("Unknown shape. Please choose: 1, 2 or 3 for the shape.");
        }
        scanner.close();

    }

    public static void outputCalculatedArea(String output){
        System.out.println(output);
    }
}
