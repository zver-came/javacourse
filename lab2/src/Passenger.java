public class Passenger {
    //Date birthday;
    public boolean inCar = false;
    public String Name;
    public String Surname;
    Passenger(String name, String surname){
        Name = name;
        Surname = surname;
    }

    @Override
    public String toString() { return "Passenger["+Integer.toHexString(hashCode())+"]:\t" + Name + ", " + Surname; }
}
