package springreact.demo.gson_examples;

public class Artist {
    public static int ID = 0;

    public int id;
    public String name;
    public int yearBorn;
    public boolean isDeceased = false;

    public Artist(String name, int yearBorn) {
        this(name, yearBorn, false);
    }

    public Artist(String name, int yearBorn, boolean isDeceased) {
        this.id = ID++;
        this.name = name;
        this.yearBorn = yearBorn;
        this.isDeceased = isDeceased;
    }
}
