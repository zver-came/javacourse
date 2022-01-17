import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public interface ReadWrite {
    default List<Passenger> read() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        ObjectInputStream input = new ObjectInputStream(fileInputStream);
        //System.out.println(input.readObject());
        List<Passenger> passengers = new ArrayList<>(); //List<Passenger>) input.readObject();
        input.close();
        return passengers;
    }
    default void write(Passenger passenger) throws IOException, ClassNotFoundException {
        List<Passenger> passengers = read();
        passengers.add(passenger);
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
        output.writeObject(passengers);
        output.close();
    }
}
