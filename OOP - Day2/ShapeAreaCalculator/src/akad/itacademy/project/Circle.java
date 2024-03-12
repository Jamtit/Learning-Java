package akad.itacademy.project;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends Shape{
    public Circle(float radius) {
        super(radius, radius);
    }

    @Override
    public void calculateArea() {
        super.rectangleArea();
        BigDecimal circleArea = new BigDecimal(super.getAreaSize() * Math.PI);
        super.setAreaSize(circleArea.setScale(2, RoundingMode.UP).floatValue());
    }
}
