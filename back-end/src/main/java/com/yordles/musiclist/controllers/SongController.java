package com.yordles.musiclist.controllers;

import com.yordles.musiclist.models.PlayList;
import com.yordles.musiclist.models.PlayListHasSong;
import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.services.PlayListService;
import com.yordles.musiclist.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class is a controller class that will handle the HTTP requests related
 * to songs. This class will typically interact with the service class to get
 * the data from the database and return it to the client in the form of a JSON
 * object.
 *
 * Endpoints:
 *
 * 1. GET /song/all: This endpoint is used to get all the songs from the
 * database.
 *
 * 2. POST /song/add: This endpoint is used to add a new song to the database.
 *
 * 3. DELETE /song/delete/{id}: This endpoint is used to delete a song from the
 * database.
 *
 * 4. PUT /song/update/{id}: This endpoint is used to update a song in the
 * database.
 *
 */

@RestController
@RequestMapping(path = "/song")
public class SongController {

    @Autowired
    private SongService songService;

    @Autowired
    private PlayListService playListService;

    /**
     * This method is used to get all the songs from the database, it is called
     * when a GET request is made to /song/all, it returns a JSON object with all
     * the songs.
     *
     * @return ResponseEntity<Iterable<Song>> This returns a JSON object with all
     *         the songs
     *
     * @GetMapping: This annotation is used to map the HTTP GET requests to the
     *              handler methods. It has many attributes.
     */
    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<Song>> getAllSongs() throws Exception {

        Iterable<Song> songs = songService.findAllSongs();

        if (songs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    /**
     * This method is used to add a new song to the database, it is called when a
     * POST request is made to /song/add, it returns a JSON object with the new song
     * that was added.
     *
     * @param song This is the song object that will be added to the database.
     * @return ResponseEntity<Song> This returns a JSON object with the new song
     *         that was added.
     * @PostMapping: This annotation is used to map the HTTP POST requests to the
     *               handler methods. It has many attributes.
     *               <p>
     */
    @PostMapping(path = "/add")
    public ResponseEntity<Song> addNewSong(@RequestBody Song song) throws Exception {

        if (song.getPlayListHasSongs() != null) {

            for (PlayListHasSong playListHasSong : song.getPlayListHasSongs()) {
                playListHasSong.setSong(song);
                Long playListId = playListHasSong.getPlayList().getId();
                PlayList playList = playListService.findPlayListById(playListId);
                playListHasSong.setPlayList(playList);
            }
        }

        Song songToSave = songService.saveSong(song);

        if (songToSave == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(songToSave, HttpStatus.OK);
    }

    @PostMapping(path = "/addMany")
    public ResponseEntity<Iterable<Song>> addNewSongs(@RequestBody Iterable<Song> songs) throws Exception {
        Iterable<Song> savedSongs = songService.saveManySongs(songs);

        if (savedSongs == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(savedSongs, HttpStatus.CREATED);
    }

    /**
     * This method is used to update a song in the database, it is called when a
     * PUT request is made to /song/update/{id}, it returns a JSON object with the
     * song that was updated.
     *
     * @param id   This is the id of the song that will be updated in the database.
     * @param song This is the song object that will be updated in the database.
     * @return ResponseEntity<Song> This returns a JSON object with the song that
     *         was updated.
     * @PutMapping: This annotation is used to map the HTTP PUT requests to
     *              the handler methods. It has many attributes.
     *              <p>
     */
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateSongById(@PathVariable Long id, @RequestBody Song song) throws Exception {
            
            Song songToUpdate = songService.updateSong(id, song);
    
            if (songToUpdate == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    
            return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * This method is used to delete a song from the database, it is called when a
     * DELETE request is made to /song/delete/{id}, it returns a JSON object with
     * the
     * song that was deleted.
     *
     * @param id This is the id of the song that will be deleted from the database.
     * @return ResponseEntity<Song> This returns a JSON object with the song that
     *         was deleted.
     *
     * @DeleteMapping: This annotation is used to map the HTTP DELETE requests to
     *                 the handler methods. It has many attributes.
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Song> deleteSongById(@PathVariable Long id) throws Exception {
        Song song = songService.findSongById(id);

        if (song == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        songService.deleteSongById(id);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
