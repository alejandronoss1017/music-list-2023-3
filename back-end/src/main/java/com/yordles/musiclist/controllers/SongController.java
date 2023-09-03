package com.yordles.musiclist.controllers;


import com.yordles.musiclist.models.Genre;
import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.models.DTO.SongRequest;
import com.yordles.musiclist.services.GenreService;
import com.yordles.musiclist.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

@Controller
@RequestMapping(path = "/song")
public class SongController {

    @Autowired
    private SongService songService;

    @Autowired
    private GenreService genreService;

    /**
     * This method is used to get all the songs from the database, it is called
     * when a GET request is made to /song/all, it returns a JSON object with all
     * the songs.
     *
     * @return ResponseEntity<Iterable<Song>> This returns a JSON object with all
     * the songs
     *
     * @GetMapping: This annotation is used to map the HTTP GET requests to the
     *             handler methods. It has many attributes.
     *
     * By StiivenOrtiz
     *
     */
    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<Song>> getAllSongs() throws Exception {
        return ResponseEntity.ok().body(songService.findAllSongs());
    }

    /**
     * This method is used to add a new song to the database, it is called when a
     * POST request is made to /song/add, it returns a JSON object with the new song
     * that was added.
     *
     * @param song This is the song object that will be added to the database.
     * @return ResponseEntity<Song> This returns a JSON object with the new song
     * that was added.
     * @PostMapping: This annotation is used to map the HTTP POST requests to the
     * handler methods. It has many attributes.
     * <p>
     * By StiivenOrtiz
     */
    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewSong(@RequestBody SongRequest songRequest) throws Exception {
        Song song = new Song(songRequest);

        Set<Genre> genres = genreService.findGenreByIds(songRequest.getGenres());

        for (Genre genre : genres) {
            song.addGenre(genre);
        }

        songService.saveSong(song);
        return ResponseEntity.ok().body("Saved");
    }

    /**
     * This method is used to delete a song from the database, it is called when a
     * DELETE request is made to /song/delete/{id}, it returns a JSON object with the
     * song that was deleted.
     *
     * @param id This is the id of the song that will be deleted from the database.
     * @return ResponseEntity<Song> This returns a JSON object with the song that
     *        was deleted.
     *
     * @DeleteMapping: This annotation is used to map the HTTP DELETE requests to
     *                the handler methods. It has many attributes.
     *
     * By StiivenOrtiz
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Song> deleteSongById(@PathVariable Long id) throws Exception {
        Song song = songService.findSongById(id);
        songService.deleteSongById(id);
        return ResponseEntity.ok().body(song);
    }

    /**
     * This method is used to update a song in the database, it is called when a
     * PUT request is made to /song/update/{id}, it returns a JSON object with the
     * song that was updated.
     *
     * @param id   This is the id of the song that will be updated in the database.
     * @param song This is the song object that will be updated in the database.
     * @return ResponseEntity<Song> This returns a JSON object with the song that
     * was updated.
     * @PutMapping: This annotation is used to map the HTTP PUT requests to
     * the handler methods. It has many attributes.
     * <p>
     * By StiivenOrtiz
     */
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<String> updateSongById(@RequestBody SongRequest songRequest, @PathVariable Long id) throws Exception {
        Set<Genre> genres = genreService.findGenreByIds(songRequest.getGenres());
        songService.updateSong(id, songRequest, genres);
        return ResponseEntity.ok().body("Updated");
    }
}
