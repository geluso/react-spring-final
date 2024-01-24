package springreact.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/top-songs")
public class TopSongController {
    @Autowired
    private TopSongRepository topSongRepository;

    @GetMapping
    public @ResponseBody Iterable<TopSong> getTopSongs() {
        System.out.println("getting top songs");
        return topSongRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    public @ResponseBody TopSong createTopSong(@RequestBody TopSong request) {
        TopSong song = new TopSong();
        song.songRank = request.songRank;
        song.artist = request.artist;
        song.song = request.song;
        song.releaseYear = request.releaseYear;

        TopSong saved = topSongRepository.save(song);
        return saved;
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody boolean deleteTopSong(@PathVariable int id) {
        System.out.println("Deleting song id:" + id);

        Optional<TopSong> maybeSong = topSongRepository.findById(id);
        if (maybeSong.isEmpty()) {
            return false;
        }

        TopSong song = maybeSong.get();
        topSongRepository.delete(song);
        return true;
    }
}
