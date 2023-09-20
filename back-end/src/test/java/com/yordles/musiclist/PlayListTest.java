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

@SpringBootTest
public class PlayListTest {

    @Autowired
    private GenreService genreService;

    @Autowired
    private PlayListService playListService;

    @Test
    void testGetAllPlayLists() throws Exception {
        // Act
        Iterable<PlayList> responseEntity = playListService.findAllPlayLists();

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testGetPlayListsById() throws Exception {
        // Arrange
        Long playListId = 1L;

        // Act
        PlayList responseEntity = playListService.findPlayListById(playListId);

        // Assert
        assertNotNull(responseEntity);
    }

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
