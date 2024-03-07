package swed.itacademy.project;

public class Square extends Shape{
    public Square(float sideLength) {
        super(sideLength, sideLength);
    }

    @Override
    public void calculateArea() {
        super.rectangleArea();
    }
}
