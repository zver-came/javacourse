public class Triangle extends Shape{
    private double a;
    private double b;
    private double c;
    public Triangle(String inputShapeColor, double a, double b, double c) {
        super(inputShapeColor);
        this.a =a;
        this.b =b;
        this.c =c;
    }

    @Override
    double calcArea() {
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    public String toString(){ return "Triangle:{ "+shapeColor+" : "+calcArea()+" }"; }
}
