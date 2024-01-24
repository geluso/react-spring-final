package springreact.demo.gson_examples;

public class Instrument {
    public static int ID = 0;

    public String name;
    public int id;

    public static Instrument BASS = new Instrument("BASS");
    public static Instrument DRUMS = new Instrument("DRUMS");
    public static Instrument GUITAR = new Instrument("GUITAR");
    public static Instrument PIANO = new Instrument("PIANO");
    public static Instrument TRUMPET = new Instrument("TRUMPET");
    public static Instrument VOCALS = new Instrument("VOCALS");

    public Instrument(String name) {
        this.name = name;
        this.id = ID++;
    }
}


