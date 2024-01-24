import { useEffect, useState } from 'react';

const TopSongs = () => {
    console.log('rendering top songs');

    const [songs, setSongs] = useState([]);

    const getTopSongs = () => {
        console.log('react is getting top songs')
        fetch("http://localhost:8080/top-songs")
        .then(res => res.json())
        .then(json => {
            console.log('top songs', json);
            // take the JSON that we got from the server
            // and update the state of the page so we can display the data
            // updating the state will trigger a rerender of this component.
            setSongs(json);
        })
    }

    // Use the useEffect hook to indicate to React that we only need to 
    // execute getTopSongs exactly one time when the page loads.
    useEffect(() => {
        // When this component "loads/renders" make a network request
        // to get the top songs data from the server.
        getTopSongs();
    }, []);

    const sanitizeYear = (value) => {
        if (value < 1900) {
            value = 1900;
        }

        value = Math.round(value);

        return value;
    }

    const createTopSong = (ev) => {
        ev.preventDefault();

        let year = sanitizeYear(ev.target.elements.releaseYear.value);

        const data = {
            songRank: ev.target.elements.songRank.value,
            artist: ev.target.elements.artist.value,
            song: ev.target.elements.song.value,
            releaseYear: year
        }

        console.log('creating song', data);

        fetch("http://localhost:8080/top-songs", {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        })
        .then(res => res.json())
        .then(json => {
            console.log('created song', json);

            setSongs([...songs, json]);
        })
    }

    const deleteSong = (id) => {
        console.log('deleting song');
        fetch("http://localhost:8080/top-songs/" + id, {
            method: 'DELETE',
        })
        .then(res => res.json())
        .then(json => {
            console.log('deleted song', json);
            getTopSongs();
        })
    }

    return <div>
        <h1>Top Songs</h1>
        <p>These are history's top songs!</p>
        <div>
            <form onSubmit={createTopSong}>
                <input placeholder="songRank" name="songRank" type="number" />
                <input placeholder="artist" name="artist" />
                <input placeholder="song" name="song" />
                <input placeholder="releaseYear" name="releaseYear" type="number" />
                <input type="submit" value="save" />
            </form>
        </div>
        <div>
            {songs.map(song => {
                return <div key={song.id}>
                    <span onClick={() => deleteSong(song.id)}>(X)</span>
                    {song.songRank}
                    {song.artist}
                    {song.song}
                    {song.releaseYear}
                </div>
            })}
        </div>
    </div>
}

export default TopSongs;