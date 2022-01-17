import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int count = 12;
    private static Shape[] array;
    private static Random r;
    public static void main(String[] args) {
        array = new Shape[count];
        r = new Random();
        initArray();

        //Print values
        printArray();
        System.out.println("-".repeat(150));
        printMainArea();
        printAreaByType();

        //Sort Area
        System.out.println("-".repeat(150)+"\nSort by Area\n"+"-".repeat(150));
        SortByArea();
        printArray();

        //Sort Color
        System.out.println("-".repeat(150)+"\nSort by Color\n"+"-".repeat(150));
        SortByColor();
        printArray();
    }
    public static void initArray(){
        for (int i = 0; i < count; i++){
            array[i] = CreateElement(r.nextInt(3));
        }
    }
    public static Shape CreateElement(int i){
        Color col = getRandomColor();
        if(i == 0){
            double a = r.nextInt(count)+1;
            double b = r.nextInt(count)+1;
            double c = r.nextInt(count)+1;
            return new Triangle(col.getName(), a, b, c);
        }else if(i == 1){
            double R = r.nextInt(count)+1;
            return new Circle(col.getName(), R);
        }
        else {
            double height = r.nextInt(count)+1;
            double width = r.nextInt(count)+1;
            return new Rectangle(col.getName(), height, width);
        }
    }
    public static Color getRandomColor(){
        int rand_index = r.nextInt(Color.values().length);
        return Arrays.stream(Color.values()).filter(el->el.getIndex()==rand_index).findFirst().get();
    }


    public static void printArray(){
        for(Shape s: array) System.out.println(s);
    }
    public static void printMainArea(){
        double sum = 0;
        for(Shape s: array) sum += s.calcArea();
        System.out.println("Result Sum of all Shape: "+sum);
    }
    public static void printAreaByType(){
        double[] sum = new double[3];
        for(Shape s: array){
            if(s.getClass().equals((new Rectangle(Color.W.getName(), 0,0)).getClass())) sum[0] += s.calcArea();
            else if(s.getClass().equals((new Circle(Color.W.getName(), 0)).getClass())) sum[1] += s.calcArea();
            else sum[2] += s.calcArea();
        }
        System.out.println("Result Sum of all Rectangle: "+sum[0]);
        System.out.println("Result Sum of all Triangle: "+sum[2]);
        System.out.println("Result Sum of all Circle: "+sum[1]);
    }

    public static void SortByArea(){
        Arrays.sort(array, new ComparatorArea());
    }
    public static void SortByColor(){
        Arrays.sort(array, new ComparatorColor());
    }
}