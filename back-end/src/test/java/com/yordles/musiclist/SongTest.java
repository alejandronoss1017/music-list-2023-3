package com.yordles.musiclist;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.services.SongService;

@SpringBootTest
public class SongTest {

    @Autowired
    private SongService songService;

    @Test
    void testGetAllSongs() throws Exception {
        // Act
        Iterable<Song> responseEntity = songService.findAllSongs();

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testGetSongsById() throws Exception {
        // Arrange
        Long SongId = 1L;

        // Act
        Song responseEntity = songService.findSongById(SongId);

        // Assert
        assertNotNull(responseEntity);
    }

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
