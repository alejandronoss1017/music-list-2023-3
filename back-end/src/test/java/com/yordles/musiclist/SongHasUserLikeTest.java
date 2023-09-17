package com.yordles.musiclist;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yordles.musiclist.models.SongHasUserLike;
import com.yordles.musiclist.models.User;
import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.models.EmbeddedKeys.SongHasUserLikeId;
import com.yordles.musiclist.services.SongHasUserLikeService;
import com.yordles.musiclist.services.SongService;
import com.yordles.musiclist.services.UserService;

@SpringBootTest
public class SongHasUserLikeTest {

    @Autowired
    private SongHasUserLikeService songHasUserLikeService;

    @Autowired
    private SongService songService;

    @Autowired
    private UserService userService;

    @Test
    void testGetAllSongHasUserLikes() throws Exception {
        // Act
        Iterable<SongHasUserLike> responseEntity = songHasUserLikeService.findAllSongHasUserLikes();

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testGetSongHasUserLikesById() throws Exception {
        // Arrange
        SongHasUserLikeId SongHasUserLikeId = new SongHasUserLikeId(1L, 1L);

        // Act
        SongHasUserLike responseEntity = songHasUserLikeService.findSongHasUserLikeById(SongHasUserLikeId);

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testAddNewSongHasUserLike() throws Exception {
        // Arrange
        Song song = songService.findSongById(1L);
        User user = userService.findUserById(1l);

        // Act
        SongHasUserLike responseEntity = songHasUserLikeService.saveSongHasUserLike(song, user);

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testDeleteSongHasUserLike() {
        // Arrange
        Song song = songService.findSongById(1L);
        User user = userService.findUserById(1l);

        // Act
        songHasUserLikeService.deleteSongHasUserLikeById(song, user);

        SongHasUserLikeId SongHasUserLikeId = new SongHasUserLikeId(1L, 1L);
        SongHasUserLike responseEntity = songHasUserLikeService.findSongHasUserLikeById(SongHasUserLikeId);

        // Assert
        assertNull(responseEntity);
    }
}
