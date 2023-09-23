package com.yordles.musiclist;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yordles.musiclist.models.Genre;
import com.yordles.musiclist.models.PlayList;
import com.yordles.musiclist.services.GenreService;
import com.yordles.musiclist.services.PlayListService;

/**
 *
 * @name PlayListTest
 *
 * @description This class tests the PlayListService class.
 * @see com.yordles.musiclist.services.PlayListService
 * @version 1.0
 *
 * @since 2023-09-22
 *
 */
@SpringBootTest
public class PlayListTest {

    @Autowired
    private GenreService genreService; // This annotation tells Spring to inject an instance of GenreService here.

    @Autowired
    private PlayListService playListService; // This annotation tells Spring to inject an instance of PlayListService here.

    /**
     *
     * @name testGetAllPlayLists
     *
     * @description This method tests the getAllPlayLists method from the PlayListService class.
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
    void testGetAllPlayLists() throws Exception {
        // Act
        Iterable<PlayList> responseEntity = playListService.findAllPlayLists();

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testGetPlayListsById
     *
     * @description This method tests the getPlayListsById method from the PlayListService class.
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
    void testGetPlayListsById() throws Exception {
        // Arrange
        Long playListId = 1L;

        // Act
        PlayList responseEntity = playListService.findPlayListById(playListId);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testAddNewPlayList
     *
     * @description This method tests the addNewPlayList method from the PlayListService class.
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
    void testAddNewPlayList() throws Exception {
        // Arrange
        PlayList playListToSave = new PlayList();
        playListToSave.setName("TestNewPlayList");
        Genre genre = genreService.findGenreById(1L);
        playListToSave.setGenre(genre);

        // Act
        PlayList responseEntity = playListService.savePlayList(playListToSave);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testUpdatePlayList
     *
     * @description This method tests the updatePlayList method from the PlayListService class.
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
    void testDeletePlayListById() {
        // Arrange
        Long idToDelete = 1L;

        // Act
        playListService.deletePlayListById(idToDelete);

        // Assert
        PlayList deletedPlayList = playListService.findPlayListById(idToDelete);
        assertNull(deletedPlayList);
    }

    /**
     *
     * @name testDeletePlayList
     *
     * @description This method tests the deletePlayList method from the PlayListService class.
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
    void testDeletePlayList() {
        // Arrange
        PlayList responseEntity = playListService.findPlayListById(1L);

        // Act
        playListService.deletePlayList(responseEntity);

        // Assert
        PlayList deletedPlayList = playListService.findPlayListById(responseEntity.getId());
        assertNull(deletedPlayList);
    }
}
