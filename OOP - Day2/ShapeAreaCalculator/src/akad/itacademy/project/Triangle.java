package akad.itacademy.project;

public class Triangle extends Shape{
    public Triangle(float sideLength1, float sideLength2) {
        super(sideLength1, sideLength2);
    }

    @Override
    public void calculateArea() {
        super.rectangleArea();
        float rightTriangleArea = super.getAreaSize()/2;
        super.setAreaSize(rightTriangleArea);
    }

}
