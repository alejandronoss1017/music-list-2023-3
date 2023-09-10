package com.yordles.musiclist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yordles.musiclist.models.PlayList;
import com.yordles.musiclist.models.PlayListHasSong;
import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.models.Genre;
import com.yordles.musiclist.services.GenreService;
import com.yordles.musiclist.services.PlayListService;
import com.yordles.musiclist.services.SongService;

@RestController
@RequestMapping(path = "/playlist")
public class PlayListController {
    
    @Autowired
    private PlayListService playListService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private SongService songService;

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<PlayList>> getAllPlayLists() {
        Iterable<PlayList> playlists = playListService.findAllPlayLists();

        if (playlists == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PlayList> getPlayListById(@PathVariable Long id) {
        PlayList playList = playListService.findPlayListById(id);

        if (playList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(playList, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> addNewPlayList(@RequestBody PlayList playList) throws Exception {

        Genre genre = playList.getGenre();

        if (playList.getGenre().getId() == null) {
            genre = genreService.findGenreByName(playList.getGenre().getName());
        } else {
            genre = genreService.findGenreById(playList.getGenre().getId());
        }

        if (genre == null) {
            return new ResponseEntity<>("The genre specified doesn't exist", null, HttpStatus.BAD_REQUEST);
        }

        if (playList.getPlayListHasSongs() != null) {

            for (PlayListHasSong playListHasSong : playList.getPlayListHasSongs()) {
                playListHasSong.setPlayList(playList);
                Long songId = playListHasSong.getSong().getId();
                Song song = songService.findSongById(songId);
                playListHasSong.setSong(song);
            }

        }

        playList.setGenre(genre);
        playListService.savePlayList(playList);

        return new ResponseEntity<>(playList, HttpStatus.CREATED);
    }

    @PostMapping(path = "/addMany")
    public ResponseEntity<Iterable<PlayList>> addNewPlayLists(@RequestBody Iterable<PlayList> playLists) {

        if (playLists == null) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        for (PlayList playList : playLists) {

            Genre genre = playList.getGenre();

            if (playList.getGenre().getId() == null) {
                genre = genreService.findGenreByName(playList.getGenre().getName());
            } else {
                genre = genreService.findGenreById(playList.getGenre().getId());
            }

            if (genre == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            playList.setGenre(genre);

            if (playList.getPlayListHasSongs() != null) {

                for (PlayListHasSong playListHasSong : playList.getPlayListHasSongs()) {
                    playListHasSong.setPlayList(playList);
                    Long songId = playListHasSong.getSong().getId();
                    Song song = songService.findSongById(songId);
                    playListHasSong.setSong(song);
                }

            }

        }

        Iterable<PlayList> savedPlayLists = playListService.saveManyPlayLists(playLists);

        if (savedPlayLists == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(savedPlayLists, HttpStatus.CREATED);
    }

    @PutMapping(path = "/update/{id}")
    public String updatePlayList(@PathVariable Long id) {
        return "Updated";
    }

    @PatchMapping(path = "/patch/{id}")
    public String PatchPlayList(@PathVariable Long id) {
        return "Patched";
    }

        @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<PlayList> deletePlayList(@PathVariable Long id) {
        PlayList playList = playListService.findPlayListById(id);

        if (playList == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        playListService.deletePlayList(playList);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
