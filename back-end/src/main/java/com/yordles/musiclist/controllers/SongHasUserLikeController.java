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
import com.yordles.musiclist.models.SongHasUserLike;
import com.yordles.musiclist.models.User;
import com.yordles.musiclist.models.EmbeddedKeys.SongHasUserLikeId;
import com.yordles.musiclist.services.SongHasUserLikeService;
import com.yordles.musiclist.services.SongService;
import com.yordles.musiclist.services.UserService;

@RestController
@RequestMapping(path = "/songLike")
public class SongHasUserLikeController {
       
    @Autowired
    private SongHasUserLikeService songHasUserLikeService;

    @Autowired
    private SongService songService;

    @Autowired
    private UserService userService;

    /**
     * This method is used to get all the songHasUserLikes from the database, it is called
     * when a GET request is made to /songHasUserLike/all, it returns a JSON object with all
     * the songHasUserLikes.
     * 
     * @return ResponseEntity<Iterable<songHasUserLike>> This returns a JSON object with all
     *         the songHasUserLikes otherwise it returns a 404 NOT FOUND response status to
     *         indicate that the requested resource could not be found.
     * 
     * @throws Exception If there is an error getting the songHasUserLikes from the database
     *                   this exception is thrown
     */
    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<SongHasUserLike>> getAllsongHasUserLikes() throws Exception {

        Iterable<SongHasUserLike> songHasUserLikes = songHasUserLikeService.findAllSongHasUserLikes();

        if (songHasUserLikes == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // 1. ResponseEntity: This is the main class that represents an HTTP response.
        // It's used to encapsulate the response status, headers, and body.
        //
        // 2. <>: This is the type parameter. It specifies the type of the
        // response body. It can be inferred by the compiler.
        return new ResponseEntity<>(songHasUserLikes, HttpStatus.OK);
    }

    /**
     * This method is used to get a songHasUserLike from the database, it is called when a GET
     * request is made to /songHasUserLike/{id}, it returns a JSON object with the songHasUserLike
     * that was found in the database.
     * 
     * @param id The id of the songHasUserLike to be retrieved from the database
     * 
     * @return ResponseEntity<songHasUserLike> This returns a JSON object with the songHasUserLike that
     *         was found in the database, otherwise it returns a 404 NOT FOUND response
     *         status to indicate that the requested resource could not be found.
     * 
     * @throws Exception If there is an error getting the songHasUserLike from the database
     *                   this exception is thrown
     */
    @GetMapping(path = "/get/{songId}/{userId}")
    public ResponseEntity<SongHasUserLike> getSongHasUserLikeById(@PathVariable Long songId, @PathVariable Long userId) throws Exception {
        SongHasUserLikeId id = new SongHasUserLikeId(songId, userId);

        SongHasUserLike songHasUserLike = songHasUserLikeService.findSongHasUserLikeById(id);

        if (songHasUserLike == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(songHasUserLike, HttpStatus.OK);
    }

    /**
     * This method is used to add a new songHasUserLike to the database, it is called when a
     * POST request is made to /songHasUserLike/add, it expects a JSON object with the name of
     * the songHasUserLike.
     * 
     * @param songHasUserLike The songHasUserLike to be added to the database
     * @return ResponseEntity<songHasUserLike> This returns a JSON object with the songHasUserLike that
     *         was added to the database
     * @throws Exception If there is an error adding the songHasUserLike to the database this
     *                   exception is thrown
     */
    @PostMapping(path = "/add/{songId}/{userId}")
    public ResponseEntity<SongHasUserLike> addNewsongHasUserLike(@PathVariable Long songId, @PathVariable Long userId) throws Exception {
        
        Song song = songService.findSongById(songId);
        User user = userService.findUserById(userId);

        if (song == null || user == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        SongHasUserLike songHasUserLikeToSave = songHasUserLikeService.saveSongHasUserLike(song, user);

        if (songHasUserLikeToSave == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(songHasUserLikeToSave, HttpStatus.CREATED);
    }

    /**
     * This method is used to delete a songHasUserLike from the database, it is called when a
     * DELETE request is made to /songHasUserLike/delete/{id}.
     * 
     * @param id The id of the songHasUserLike to be deleted
     * 
     * @return ResponseEntity<songHasUserLike> This returns a JSON object with the songHasUserLike that
     *         was not found in the database, otherwise it returns a 204 NO CONTENT
     *         response status to indicate that the request has succeeded completely
     *         and that the server has no additional content to send in the
     *         response.
     * 
     * @throws Exception If there is an error deleting the songHasUserLike from the database
     *                   this exception is thrown
     */
    @DeleteMapping(path = "/delete/{songId}/{userId}")
    public ResponseEntity<SongHasUserLike> deletesongHasUserLike(@PathVariable Long songId, @PathVariable Long userId) throws Exception {

        Song song = songService.findSongById(songId);
        User user = userService.findUserById(userId);

        if (song == null || user == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        songHasUserLikeService.deleteSongHasUserLikeById(song, user);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    } 
}
