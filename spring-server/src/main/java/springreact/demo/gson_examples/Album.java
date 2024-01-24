package springreact.demo.gson_examples;

import java.util.ArrayList;
import java.util.List;

public class Album {
    public static int ID = 0;

    public int id;
    public String title;
    public int yearReleased;
    public Artist artist;
    public List<Song> songs;

    public Album(String title, int yearReleased, Artist artist) {
        this(title, yearReleased, artist, new ArrayList<>());
    }

    public Album(String title, int yearReleased, Artist artist, List<Song> songs) {
        this.id = ID++;
        this.title = title;
        this.yearReleased = yearReleased;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }
}
