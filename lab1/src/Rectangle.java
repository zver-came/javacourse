public class Rectangle extends Shape{
    private double height;
    private double width;
    public Rectangle(String inputShapeColor, double height, double width) {
        super(inputShapeColor);
        this.height = height;
        this.width = width;
    }
    @Override
    double calcArea() { return this.height*this.width; }

    @Override
    public String toString(){ return "Rectangle:{ "+shapeColor+" : "+calcArea()+" }"; }
}
