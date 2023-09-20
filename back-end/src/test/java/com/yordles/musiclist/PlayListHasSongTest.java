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

@SpringBootTest
public class PlayListHasSongTest {

    @Autowired
    private SongService songService;

    @Autowired
    private PlayListService playListService;

    @Autowired
    private PlayListHasSongService playListHasSongService;

    @Test
    void testGetAllPlayListHasSongs() throws Exception {
        // Act
        Iterable<PlayListHasSong> responseEntity = playListHasSongService.findAllPlayListHasSongs();

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testGetPlayListHasSongsById() throws Exception {
        // Arrange
        PlayListHasSongId PlayListHasSongId = new PlayListHasSongId(1L, 1L);

        // Act
        PlayListHasSong responseEntity = playListHasSongService.findPlayListHasSongById(PlayListHasSongId);

        // Assert
        assertNotNull(responseEntity);
    }

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
