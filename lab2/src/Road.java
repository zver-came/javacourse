import java.util.ArrayList;
import java.util.List;

public class Road implements Message{
    private List<Vehicle> carsInRoad;
    Road(){ carsInRoad = new ArrayList<>();}
    public int getCountOfHumans(){
        int sum = 0;
        try{
            if(carsInRoad.size()>0) {
                for(Vehicle v : carsInRoad) {
                    sum += v.occupiedSeatsCount();
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        Head("Підрахунок пасажирів на автошляху.");
        Info("Кількість людей на автошляху["+Integer.toHexString(hashCode())+"]: " + sum);
        Border();
        return sum;
    }
    public void addCarToRoad(Vehicle car){
        Head("Додавання автотранспорту до автошляху.");
        try {
            carsInRoad.add(car);
            SuccessInfo("Автотранспорт["+car+"] успішно додано до шляху["+this+"].");
        }
        catch (Exception e){
            ErrorInfo(e.getMessage(), "Автотранспорт не додано до шляху.");
        }
    }

    @Override
    public String toString() {
        return "Road:{"+Integer.toHexString(hashCode())+"}, Vehicles:{"+carsInRoad.size()+"}, Passenger:{"+getCountOfHumans()+"}";
    }
}
