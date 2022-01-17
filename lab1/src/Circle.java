public class Circle extends Shape{
    private double radius;
    public Circle(String inputShapeColor, double R) {
        super(inputShapeColor);
        radius = R;
    }

    @Override
    double calcArea() { return Math.PI*radius*radius; }

    @Override
    public String toString(){ return "Circle:{ "+shapeColor+" : "+calcArea()+" }"; }
}