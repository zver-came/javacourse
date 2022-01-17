import java.util.concurrent.ForkJoinPool;

public class Main {
    static byte minValue = 0;
    static byte maxValue = 100;
    static int length = 1000000;

    public static void main(String[] args) {
        int[] array = getInitArray(length);
        RecursiveArraySum counter = new RecursiveArraySum(array);

        //initial values
        System.out.println("-".repeat(50)+"\nArray.length: 1000000, element range: 0-100.");

        long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int result = forkJoinPool.invoke(counter);
        long endTime = System.currentTimeMillis();

        //the resulting sum of 1000000 of elements
        System.out.println("\tSUM: " + result);
        //time costs
        System.out.println("\tThat took " + (endTime - startTime) + " milliseconds.\n"+"-".repeat(50));
    }

    public static int[] getInitArray(int capacity) {
        int[] values = new int[capacity];
        for(int i = 0; i < capacity; i++){
            values[i] = (int) ((Math.random() * (maxValue - minValue)) + minValue);
        }
        return values;
    }
}
