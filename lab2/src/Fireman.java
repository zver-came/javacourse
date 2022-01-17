enum FiremanRank {Senior, Middle, Junior}
class Fireman extends Passenger{
    FiremanRank Rank;

    Fireman(String name, String surname, FiremanRank rank) {
        super(name, surname);
        Rank = rank;
    }
    @Override
    public String toString() { return "Fireman["+Integer.toHexString(hashCode())+"]:\t" + Name + ", " + Surname+" -> " + Rank; }
}
