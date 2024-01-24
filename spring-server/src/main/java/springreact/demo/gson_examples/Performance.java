package springreact.demo.gson_examples;

public class Performance {
    public static int ID = 0;

    public int id;
    public int artistId;
    public int songId;
    public int instrumentId;

    public Performance(int artistId, int songId, int instrumentId) {
        this.id = ID++;
        this.artistId = artistId;
        this.songId = songId;
        this.instrumentId = instrumentId;
    }
}
