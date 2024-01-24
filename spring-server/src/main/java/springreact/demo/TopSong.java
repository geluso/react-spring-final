package springreact.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TopSong {

    public String artist;

    public Integer songRank;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer topSongBarcode;

    public String song;

    public Integer releaseYear;
}
