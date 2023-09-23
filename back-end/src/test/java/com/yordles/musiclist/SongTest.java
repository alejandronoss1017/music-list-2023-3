package com.yordles.musiclist;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.services.SongService;

/**
 *
 * @name SongTest
 *
 * @description This class tests the SongService class.
 * @see com.yordles.musiclist.services.SongService
 * @version 1.0
 *
 * @since 2023-09-22
 *
 */
@SpringBootTest
public class SongTest {

    @Autowired
    private SongService songService; // This annotation tells Spring to inject an instance of SongService here.

    /**
     *
     * @name testGetAllSongs
     *
     * @description This method tests the getAllSongs method from the SongService class.
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
    void testGetAllSongs() throws Exception {
        // Act
        Iterable<Song> responseEntity = songService.findAllSongs();

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testGetSongsById
     *
     * @description This method tests the getSongsById method from the SongService class.
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
    void testGetSongsById() throws Exception {
        // Arrange
        Long SongId = 1L;

        // Act
        Song responseEntity = songService.findSongById(SongId);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testAddNewSong
     *
     * @description This method tests the addNewSong method from the SongService class.
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
    void testAddNewSong() throws Exception {
        // Arrange
        Song SongToSave = new Song();
        SongToSave.setName("TestNewSong");
        SongToSave.setArtist("TestNewSong");
        SongToSave.setAlbum("TestNewSong");
        SongToSave.setDuration(3.14);
        SongToSave.setReleaseDate(new Date());

        // Act
        Song responseEntity = songService.saveSong(SongToSave);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testUpdateSong
     *
     * @description This method tests the updateSong method from the SongService class.
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
    void testUpdateSong() {
        // Arrange
        Long idToUpdate = 1L;

        Song SongToSave = new Song();
        SongToSave.setName("TestUpdateSong");
        SongToSave.setArtist("TestUpdateSong");
        SongToSave.setAlbum("TestUpdateSong");
        SongToSave.setDuration(3.15);
        SongToSave.setReleaseDate(new Date());

        // Act
        Song responseEntity = songService.updateSong(idToUpdate, SongToSave);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testDeleteSong
     *
     * @description This method tests the deleteSong method from the SongService class.
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
    void testDeleteSong() {
        // Arrange
        Song responseEntity = songService.findSongById(1L);

        // Act
        songService.deleteSong(responseEntity);

        // Assert
        Song deletedSong = songService.findSongById(responseEntity.getId());
        assertNull(deletedSong);
    }
}
