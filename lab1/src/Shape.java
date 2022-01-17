public abstract class Shape implements Drawable {
    public String shapeColor;
    abstract double calcArea();
    public Shape(String inputShapeColor){ this.shapeColor = inputShapeColor; }

    @Override
    public void draw() { System.out.println("draw Shape"); }

    @Override
    public String toString(){ return "toString Shape"; }
}