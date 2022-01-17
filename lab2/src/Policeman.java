enum PolicemanRank {Sergeant, Lieutenant, Captain}
class Policeman extends Passenger{
    public PolicemanRank Rank;

    Policeman(String name, String surname, PolicemanRank rank) {
        super(name, surname);
        Rank = rank;
    }
    @Override
    public String toString()  { return "Policeman["+Integer.toHexString(hashCode())+"]:\t" + Name + ", " + Surname+" -> " + Rank; }
}
