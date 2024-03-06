package swed.itacademy.project;

public abstract class Shape {
    private float areaSize;
    private float sideLength1;
    private float sideLength2;

    public Shape(float sideLength1, float sideLength2) {
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
    }

    public abstract void calculateArea();

    public void rectangleArea(){
        this.areaSize = this.sideLength2 * this.sideLength1;
    }

    public float getAreaSize() {
        return areaSize;
    }

    public void setAreaSize(float areaSize) {
        this.areaSize = areaSize;
    }

    @Override
    public String toString() {
        return "The area size of your shape is " +
                areaSize +
                "cm2";
    }
}
