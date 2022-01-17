import kotlin.io.ByteStreamsKt;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RecursiveArraySum extends RecursiveTask<Integer> {
    private int[] values = null;

    public RecursiveArraySum(int[] array) { this.values = array; }

    @Override
    protected Integer compute() {
        if(values.length <= 20)  return Arrays.stream(values).sum();
        RecursiveArraySum firstPart = new RecursiveArraySum(Arrays.copyOfRange(values, 0, values.length/2));
        RecursiveArraySum secondPart = new RecursiveArraySum(Arrays.copyOfRange(values, values.length/2, values.length));
        firstPart.fork();
        secondPart.fork();
        return firstPart.join() + secondPart.join();
    }
}