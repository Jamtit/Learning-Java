package swed.itacademy.project;

public class AreaCalculator {
    public static void main(String[] args){
        runProgram();
    }

    public static void runProgram(){
        getUserInput();
        showCalculatedArea();
    }

    private static void getUserInput(){

        InputOutputManager.chooseAShape();
        try{
            InputOutputManager.receiveAdditionalDataOfShape(InputOutputManager.getShape());
        }catch (UnknownShapeException e){
            System.out.println(e.getMessage());
        }
    }

    private static void showCalculatedArea(){
        Shape shape = switch (InputOutputManager.getShape()){
            case 1:
                {yield new Square(InputOutputManager.getData1());}
            case 2:
                {yield new Triangle(InputOutputManager.getData1(), InputOutputManager.getData2());}
            case 3:
                {yield new Circle(InputOutputManager.getData1());}
            default:
                {yield null;}
        };
        if(shape != null){
            shape.calculateArea();
            InputOutputManager.outputCalculatedArea(shape.toString());
        }
    }
}
