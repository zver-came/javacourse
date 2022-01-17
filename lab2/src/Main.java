import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //int command =-1;
        //List<String> level_1 = Arrays.asList("1.Створити людину", "2.Створити авто", "3.Створити автошлях");

        //while(command!=8)
    }
    public static void add(Vehicle car, Passenger passenger){
        try {
            car.boarding(passenger);
        }catch (Exception e){
            System.out.println("Add new passenger.\nERROR: " + e.getMessage());
        }
    }
    public static void remove(Vehicle car, Passenger passenger){
        try {
            car.landing(passenger);
        }catch (Exception e){
            System.out.println("Remove passenger.\nERROR: " + e.getMessage());
        }
    }
}