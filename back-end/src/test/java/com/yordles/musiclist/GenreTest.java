package com.yordles.musiclist;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yordles.musiclist.models.Genre;
import com.yordles.musiclist.services.GenreService;

@SpringBootTest
public class GenreTest {

    @Autowired
    private GenreService genreService;

    @Test
    void testGetAllGenres() throws Exception {
        // Act
        Iterable<Genre> responseEntity = genreService.findAllGenres();

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testGetGenresById() throws Exception {
        // Arrange
        Long genreId = 1L;

        // Act
        Genre responseEntity = genreService.findGenreById(genreId);

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testAddNewGenre() throws Exception {
        // Arrange
        Genre GenreToSave = new Genre();
        GenreToSave.setName("TestNewGenre");
        GenreToSave.setDescription("DescriptionNewGenre");

        // Act
        Genre responseEntity = genreService.saveGenre(GenreToSave);

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testUpdateGenre() {
        // Arrange
        Long idToUpdate = 1L;

        Genre GenreToSave = new Genre();
        GenreToSave.setName("testUpdateGenre");
        GenreToSave.setDescription("DescriptionUpdateGenre");

        // Act
        Genre responseEntity = genreService.updateGenre(idToUpdate, GenreToSave);

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testDeleteGenre() {
        // Arrange
        Long idToDelete = 1L;

        // Act
        genreService.deleteGenreById(idToDelete);

        // Assert
        Genre deletedGenre = genreService.findGenreById(idToDelete);
        assertNull(deletedGenre);
    }
}
