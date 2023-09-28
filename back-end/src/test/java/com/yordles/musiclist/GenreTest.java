package com.yordles.musiclist;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yordles.musiclist.models.Genre;
import com.yordles.musiclist.services.GenreService;

/**
 *
 * @name GenreTest
 *
 * @description This class tests the GenreService class.
 * @see com.yordles.musiclist.services.GenreService
 * @version 1.0
 *
 * @since 2023-09-22
 *
 */
@SpringBootTest
public class GenreTest {

    @Autowired
    private GenreService genreService; // This annotation tells Spring to inject an instance of GenreService here.

    /**
     *
     * @name testGetAllGenres
     *
     * @description This method tests the getAllGenres method from the GenreService class.
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
    void testGetAllGenres() throws Exception {
        // Act
        Iterable<Genre> responseEntity = genreService.findAllGenres();

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testGetGenresById
     *
     * @description This method tests the getGenresById method from the GenreService class.
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
    void testGetGenresById() throws Exception {
        // Arrange
        Long genreId = 1L;

        // Act
        Genre responseEntity = genreService.findGenreById(genreId);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testAddNewGenre
     *
     * @description This method tests the addNewGenre method from the GenreService class.
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

    /**
     *
     * @name testUpdateGenre
     *
     * @description This method tests the updateGenre method from the GenreService class.
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

    /**
     *
     * @name testDeleteGenre
     *
     * @description This method tests the deleteGenreById method from the GenreService class.
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
