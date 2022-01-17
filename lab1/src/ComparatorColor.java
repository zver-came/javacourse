import java.util.Comparator;

public class ComparatorColor implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Shape shape1 = (Shape) o1;
        Shape shape2 = (Shape) o2;

        int index1 = Color.valueOf(String.valueOf(shape1.shapeColor.charAt(0))).getIndex();
        int index2 = Color.valueOf(String.valueOf(shape2.shapeColor.charAt(0))).getIndex();
        if(index1 > index2) return 1;
        if(index1 < index2) return -1;
        return 0;
    }
}
