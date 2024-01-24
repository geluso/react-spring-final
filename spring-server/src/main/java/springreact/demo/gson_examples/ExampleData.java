package springreact.demo.gson_examples;

import java.util.ArrayList;
import java.util.List;

public class ExampleData {
    public static Artist MICHAEL_JACKSON = new Artist("Michael Jackson", 1958);
    public static Artist DAVE_GROHL = new Artist("Dave Grohl", 1969);

    public static Song WANNA_BE_STARTIN_SOMETHIN = new Song("Wanna Be Startin' Somethin' ");
    public static Song BILLIE_JEAN = new Song("Billie Jean");
    public static Song BEAT_IT = new Song("BEAT IT");

    public static List<Song> THRILLER_TRACKS = new ArrayList<>();
    static {
        THRILLER_TRACKS.add(WANNA_BE_STARTIN_SOMETHIN);
        THRILLER_TRACKS.add(BILLIE_JEAN);
        THRILLER_TRACKS.add(BEAT_IT);
    }

    public static Album THRILLER = new Album("Thriller", 1982, MICHAEL_JACKSON, THRILLER_TRACKS);
}
