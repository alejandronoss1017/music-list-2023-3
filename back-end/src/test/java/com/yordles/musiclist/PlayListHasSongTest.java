package com.yordles.musiclist;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yordles.musiclist.models.PlayList;
import com.yordles.musiclist.models.PlayListHasSong;
import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.models.EmbeddedKeys.PlayListHasSongId;
import com.yordles.musiclist.services.PlayListHasSongService;
import com.yordles.musiclist.services.PlayListService;
import com.yordles.musiclist.services.SongService;

/**
 *
 * @name PlayListHasSongTest
 *
 * @description This class tests the PlayListHasSongService class.
 * @see com.yordles.musiclist.services.PlayListHasSongService
 * @version 1.0
 *
 * @since 2023-09-22
 *
 */
@SpringBootTest
public class PlayListHasSongTest {

    @Autowired
    private SongService songService; // This annotation tells Spring to inject an instance of SongService here.

    @Autowired
    private PlayListService playListService; // This annotation tells Spring to inject an instance of PlayListService here.

    @Autowired
    private PlayListHasSongService playListHasSongService; // This annotation tells Spring to inject an instance of PlayListHasSongService here.

    /**
     *
     * @name testGetAllPlayListHasSongs
     *
     * @description This method tests the getAllPlayListHasSongs method from the PlayListHasSongService class.
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
    void testGetAllPlayListHasSongs() throws Exception {
        // Act
        Iterable<PlayListHasSong> responseEntity = playListHasSongService.findAllPlayListHasSongs();

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testGetPlayListHasSongsById
     *
     * @description This method tests the getPlayListHasSongsById method from the PlayListHasSongService class.
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
    void testGetPlayListHasSongsById() throws Exception {
        // Arrange
        PlayListHasSongId PlayListHasSongId = new PlayListHasSongId(1L, 1L);

        // Act
        PlayListHasSong responseEntity = playListHasSongService.findPlayListHasSongById(PlayListHasSongId);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testAddNewPlayListHasSong
     *
     * @description This method tests the addNewPlayListHasSong method from the PlayListHasSongService class.
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
    void testAddNewPlayListHasSong() throws Exception {
        // Arrange
        PlayList playList = playListService.findPlayListById(1L);
        Song song = songService.findSongById(1L);

        // Act
        PlayListHasSong responseEntity = playListHasSongService.savePlayListHasSong(playList, song);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testDeletePlayListHasSong
     *
     * @description This method tests the deletePlayListHasSong method from the PlayListHasSongService class.
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
    void testDeletePlayListHasSong() {
        // Arrange
        PlayList playList = playListService.findPlayListById(1L);
        Song song = songService.findSongById(1L);

        // Act
        playListHasSongService.deletePlayListHasSongById(playList, song);

        PlayListHasSongId PlayListHasSongId = new PlayListHasSongId(1L, 1L);
        PlayListHasSong responseEntity = playListHasSongService.findPlayListHasSongById(PlayListHasSongId);

        // Assert
        assertNull(responseEntity);
    }
}
