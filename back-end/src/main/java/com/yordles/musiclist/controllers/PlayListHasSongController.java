package com.yordles.musiclist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.models.PlayList;
import com.yordles.musiclist.models.PlayListHasSong;
import com.yordles.musiclist.models.EmbeddedKeys.PlayListHasSongId;
import com.yordles.musiclist.services.PlayListHasSongService;
import com.yordles.musiclist.services.SongService;
import com.yordles.musiclist.services.PlayListService;

@RestController
@RequestMapping(path = "/playlistHasSong")
public class PlayListHasSongController {
       
    @Autowired
    private PlayListHasSongService playListHasSongService;

    @Autowired
    private SongService songService;

    @Autowired
    private PlayListService playListService;

    /**
     * This method is used to get all the playListHasSongs from the database, it is called
     * when a GET request is made to /playListHasSong/all, it returns a JSON object with all
     * the playListHasSongs.
     * 
     * @return ResponseEntity<Iterable<playListHasSong>> This returns a JSON object with all
     *         the playListHasSongs otherwise it returns a 404 NOT FOUND response status to
     *         indicate that the requested resource could not be found.
     * 
     * @throws Exception If there is an error getting the playListHasSongs from the database
     *                   this exception is thrown
     */
    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<PlayListHasSong>> getAllplayListHasSongs() throws Exception {

        Iterable<PlayListHasSong> playListHasSongs = playListHasSongService.findAllPlayListHasSongs();

        if (playListHasSongs == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // 1. ResponseEntity: This is the main class that represents an HTTP response.
        // It's used to encapsulate the response status, headers, and body.
        //
        // 2. <>: This is the type parameter. It specifies the type of the
        // response body. It can be inferred by the compiler.
        return new ResponseEntity<>(playListHasSongs, HttpStatus.OK);
    }

    /**
     * This method is used to get a playListHasSong from the database, it is called when a GET
     * request is made to /playListHasSong/get/{songId}/{userId}, it returns a JSON object with the playListHasSong
     * that was found in the database.
     * 
     * @param playlistId The id of the playlist to be searched
     * @param songId The id of the song to be searched
     * @return ResponseEntity<playListHasSong> This returns a JSON object with the playListHasSong that
     *         was found in the database, otherwise it returns a 404 NOT FOUND response
     *         status to indicate that the requested resource could not be found.
     * 
     * @throws Exception If there is an error getting the playListHasSong from the database
     *                   this exception is thrown
     */
    @GetMapping(path = "/get/{playlistId}/{songId}")
    public ResponseEntity<PlayListHasSong> getplayListHasSongById(@PathVariable Long playlistId, @PathVariable Long songId) throws Exception {
        PlayListHasSongId id = new PlayListHasSongId(playlistId, songId);

        PlayListHasSong playListHasSong = playListHasSongService.findPlayListHasSongById(id);

        if (playListHasSong == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(playListHasSong, HttpStatus.OK);
    }

    /**
     * This method is used to add a new playListHasSong to the database, it is called when a
     * POST request is made to /playListHasSong/add/{songId}/{userId}, it expects a JSON object with the name of
     * the playListHasSong.
     * 
     * @param playlistId The id of the playlist to be added
     * @param songId The id of the song to be added
     * @return ResponseEntity<playListHasSong> This returns a JSON object with the playListHasSong that
     *         was added to the database
     * @throws Exception If there is an error adding the playListHasSong to the database this
     *                   exception is thrown
     */
    @PostMapping(path = "/add/{playlistId}/{songId}")
    public ResponseEntity<PlayListHasSong> addNewplayListHasSong(@PathVariable Long playlistId, @PathVariable Long songId) throws Exception {
        
        PlayList playList = playListService.findPlayListById(playlistId);
        Song song = songService.findSongById(songId);

        if (playList == null || song == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        PlayListHasSong playListHasSongToSave = playListHasSongService.savePlayListHasSong(playList, song);

        if (playListHasSongToSave == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(playListHasSongToSave, HttpStatus.CREATED);
    }

    /**
     * This method is used to delete a playListHasSong from the database, it is called when a
     * DELETE request is made to /playListHasSong/delete/{songId}/{userId}.
     * 
     * @param playlistId The id of the song to be deleted
     * @param songId The id of the user to be deleted
     * 
     * @return ResponseEntity<playListHasSong> This returns a JSON object with the playListHasSong that
     *         was not found in the database, otherwise it returns a 204 NO CONTENT
     *         response status to indicate that the request has succeeded completely
     *         and that the server has no additional content to send in the
     *         response.
     * 
     * @throws Exception If there is an error deleting the playListHasSong from the database
     *                   this exception is thrown
     */
    @DeleteMapping(path = "/delete/{playlistId}/{songId}")
    public ResponseEntity<PlayListHasSong> deleteplayListHasSong(@PathVariable Long playlistId, @PathVariable Long songId) throws Exception {

        PlayList playList = playListService.findPlayListById(playlistId);
        Song song = songService.findSongById(songId);

        if (playList == null || song == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        playListHasSongService.deletePlayListHasSongById(playList, song);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    } 
}
