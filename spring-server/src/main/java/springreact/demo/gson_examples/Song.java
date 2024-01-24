package springreact.demo.gson_examples;

public class Song {
    public static int ID = 0;

    public int id;
    public String title;

    public Song(String title) {
        this.id = ID++;
        this.title = title;
    }
}