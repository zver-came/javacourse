public enum Color {
    R("RED", 3), G("GREEN",1), B("BLUE", 0),
    Y("YELLOW", 5), O("ORANGE", 2), W("WHITE", 4);

    private String name;
    private int index;
    Color(String name, int index) {
        this.name = name;
        this.index = index;
    }
    public String getName() { return name; }
    public int getIndex() { return index; }
}