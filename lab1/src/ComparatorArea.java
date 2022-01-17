import java.util.Comparator;

public class ComparatorArea implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Shape shape1 = (Shape) o1;
        Shape shape2 = (Shape) o2;
        double shape1area = shape1.calcArea();
        double shape2area = shape2.calcArea();
        if(shape1area > shape2area) return 1;
        if(shape1area < shape2area) return -1;
        return 0;
    }
}