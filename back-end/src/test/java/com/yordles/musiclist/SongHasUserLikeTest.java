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

/**
 *
 * @name SongHasUserLikeTest
 *
 * @description This class tests the SongHasUserLikeService class.
 * @see com.yordles.musiclist.services.UserService
 * @version 1.0
 *
 * @since 2023-09-22
 *
 */
@SpringBootTest
public class SongHasUserLikeTest {

    @Autowired
    private SongHasUserLikeService songHasUserLikeService; // This annotation tells Spring to inject an instance
    // of SongHasUserLikeService here.

    @Autowired
    private SongService songService; // This annotation tells Spring to inject an instance of SongService here.

    @Autowired
    private UserService userService; // This annotation tells Spring to inject an instance of UserService here.

    /**
     *
     * @name testGetAllSongHasUserLikes
     *
     * @description This method tests the getAllSongHasUserLikes method from the
     *              SongHasUserLikeService class.
     * @param none
     * @return none
     * @throws Exception
     *
     * @by Carlos Rojas
     * @version 1.0
     * @Review by Stiven Ortiz
     * @State Tested [PASS]
     *
     * @since 2023-09-22
     *
     */
    @Test
    void testGetAllSongHasUserLikes() throws Exception {
        // Act
        Iterable<SongHasUserLike> responseEntity = songHasUserLikeService.findAllSongHasUserLikes();

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testGetSongHasUserLikesById
     *
     * @description This method tests the getSongHasUserLikesById method from the
     *              SongHasUserLikeService class.
     * @param none
     * @return none
     * @throws Exception
     *
     * @by Carlos Rojas
     * @version 1.0
     * @Review by Stiven Ortiz
     * @State Tested [PASS]
     *
     * @since 2023-09-22
     *
     */
    @Test
    void testGetSongHasUserLikesById() throws Exception {
        // Arrange
        SongHasUserLikeId SongHasUserLikeId = new SongHasUserLikeId(1L, 1L);

        // Act
        SongHasUserLike responseEntity = songHasUserLikeService.findSongHasUserLikeById(SongHasUserLikeId);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testGetSongHasUserLikesById
     *
     * @description This method tests the getSongHasUserLikesById method from the
     *              SongHasUserLikeService class.
     * @param none
     * @return none
     * @throws Exception
     *
     * @by Carlos Rojas
     * @version 1.0
     * @Review by Stiven Ortiz
     * @State Tested [PASS]
     *
     * @since 2023-09-22
     *
     */
    @Test
    void testGetSongHasUserLikesByIdNull() throws Exception {
        // Arrange
        SongHasUserLikeId SongHasUserLikeId = new SongHasUserLikeId(10000L, 100000L);

        // Act
        SongHasUserLike responseEntity = songHasUserLikeService.findSongHasUserLikeById(SongHasUserLikeId);

        // Assert
        assertNull(responseEntity);
    }

    /**
     *
     * @name testAddNewSongHasUserLike
     *
     * @description This method tests the addNewSongHasUserLike method from the
     *              SongHasUserLikeService class.
     * @param none
     * @return none
     * @throws Exception
     *
     * @by Carlos Rojas
     * @version 1.0
     * @Review by Stiven Ortiz
     * @State Tested [PASS]
     *
     * @since 2023-09-22
     *
     */
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

    /**
     *
     * @name testDeleteSongHasUserLike
     *
     * @description This method tests the deleteSongHasUserLike method from the
     *              SongHasUserLikeService class.
     * @param none
     * @return none
     * @throws Exception
     *
     * @by Carlos Rojas
     * @version 1.0
     * @Review by Stiven Ortiz
     * @State Tested [PASS]
     *
     * @since 2023-09-22
     *
     */
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
