import java.util.ArrayList;
import java.util.List;

public class Vehicle <T extends Passenger> implements Message{
    private List<T> passengers;
    protected int maxSize;

    public Vehicle(){ this(2); }
    public Vehicle(int maxsize){
        this.maxSize = maxsize;
        this.passengers = new ArrayList<>();
    }
    public int maxSeatsCount() { return maxSize; }
    public int occupiedSeatsCount() { return passengers.size(); }

    public void landing(T passenger) throws Exception {
        Head("Видалення пасажира з автотранспорту: " + this);
        int index = passengers.indexOf(passenger);
        if(index != -1){
            Info("Пасажир >>\t"+passenger+"\t<<  знаходиться в салоні.");
            try {
                passengers.remove(index);
                passenger.inCar = false;
                SuccessInfo("Пасажир успішно покинув автотранспорт.");
            }
            catch (Exception e){
                ErrorInfo(e.getMessage(), "Пасажир >>\t" +passenger+"\t<<  не зміг покинути місце.");
                throw new Exception("Помилка видалення пасажира з переліку пасажирів!. "+e.getMessage());
            }
        }
        else{
            FailInfo("Пасажир >>\t"+passenger+"\t<<  в салоні не знаходиться.");
            throw new Exception("Пасажир не знаходиться в даному автотранспорті!");
        }
    }

    public void boarding(T passenger) throws Exception {
        Head("Додавання пасажира до автотранспорту: " + this);
        if(!passenger.inCar) {
            if(maxSeatsCount()!=occupiedSeatsCount()){
                Info("В салоні є вільне місце.");
                try {
                    passengers.add(passenger);
                    passenger.inCar = true;
                    SuccessInfo("Пасажир >>\t"+passenger+"\t<< успішно зайняв місце.");
                }
                catch (Exception e){
                    ErrorInfo(e.getMessage(), "Пасажир >>\t" +passenger+"\t<<  не зміг зайняти місце.");
                    throw new Exception("Помилка додавання пасажира до переліку пасажирів!. "+e.getMessage());
                }
            }
            else {
                FailInfo("В салоні немає вільних місць.\nПасажир >>\t"+passenger+"\t<<  не може зайняти вільне місце.\n");
                throw new Exception("Відсутні вільні місця!");
            }
        }
        else {
            if(passengers.indexOf(passenger) != -1){
                FailInfo("Пасажир >>\t"+passenger+"\t<< вже знаходиться в цьому транспорті!");
                throw new Exception("Пасажир не може знаходиттись двічі в одному автотранспорті!");
            }
            else {
                FailInfo("Пасажир >>\t"+passenger+"\t<< вже знаходиться в іншому транспорті.");
                throw new Exception("Пасажир не може знаходиттись одночасно в 2 автотранспортах!");
            }
        }
    }

    @Override
    public String toString() {
        return getClass()+":{"+Integer.toHexString(hashCode())+"}, Max:{"+maxSeatsCount()+"}, Pas.{"+occupiedSeatsCount()+"}";
    }
}