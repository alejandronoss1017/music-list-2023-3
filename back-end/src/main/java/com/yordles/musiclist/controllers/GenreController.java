package com.yordles.musiclist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yordles.musiclist.models.Genre;
import com.yordles.musiclist.services.GenreService;

/**
 * This class is a Rest controller class that will handle the HTTP requests
 * related
 * to genres. This class will typically interact with the service class to get
 * the data from the database and return it to the client in the form of a JSON
 * object.
 * 
 * @RestController: This annotation is used to mark the class as a controller
 *                  class.
 * 
 * @RequestMapping: This annotation is used to map the HTTP request to the
 *                  controller class or a handler method. It has many
 *                  attributes, but the most important ones are:
 * 
 *                  1. path: This attribute is used to specify the path of the
 *                  request. It can be a string or an array of strings. If it's
 *                  not specified, it defaults to "/".
 * 
 *                  2. method: This attribute is used to specify the HTTP method
 *                  of the request. It can be a string or an array of strings.
 *                  If it's not specified, it defaults to GET.
 * 
 * @Autowired: This annotation is used to mark a dependency as autowired. It
 *             tells Spring to inject an instance of the dependency into the
 *             class.
 * 
 * @PathVariable: This annotation is used to mark a method parameter as a
 *                placeholder for a path variable. It tells Spring to inject the
 *                value of the path variable into the method parameter.
 * 
 * @RequestBody: This annotation is used to mark a method parameter as the body
 *               of the request. It tells Spring to deserialize the body of the
 *               request into an instance of the method parameter type.
 * 
 */
@RestController
@RequestMapping(path = "/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    /**
     * This method is used to get all the genres from the database, it is called
     * when a GET request is made to /genre/all, it returns a JSON object with all
     * the genres.
     * 
     * @return ResponseEntity<Iterable<Genre>> This returns a JSON object with all
     *         the genres otherwise it returns a 404 NOT FOUND response status to
     *         indicate that the requested resource could not be found.
     * 
     * @throws Exception If there is an error getting the genres from the database
     *                   this exception is thrown
     */
    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<Genre>> getAllGenres() throws Exception {

        Iterable<Genre> genres = genreService.findAllGenres();

        if (genres == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // 1. ResponseEntity: This is the main class that represents an HTTP response.
        // It's used to encapsulate the response status, headers, and body.
        //
        // 2. <>: This is the type parameter. It specifies the type of the
        // response body. It can be inferred by the compiler.
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    /**
     * This method is used to get a genre by its id, it is called when a GET request
     * is made to /genre/{id}, it returns a JSON object with the genre.
     * 
     * @param id The id of the genre to be retrieved
     * 
     * @return ResponseEntity<Genre> This returns a JSON object with the genre
     *         otherwise it returns a 404 NOT FOUND response status to indicate that
     *         the requested resource could not be found.
     * 
     * @throws Exception If there is an error getting the genre from the database
     *                   this exception is thrown
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) throws Exception {

        Genre genre = genreService.findGenreById(id);

        if (genre == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    /**
     * This method is used to add a new genre to the database, it is called when a
     * POST request is made to /genre/add, it expects a JSON object with the name of
     * the genre.
     * 
     * @param genre The genre to be added to the database
     * @return ResponseEntity<Genre> This returns a JSON object with the genre that
     *         was added to the database
     * @throws Exception If there is an error adding the genre to the database this
     *                   exception is thrown
     */
    @PostMapping(path = "/add")
    public ResponseEntity<Genre> addNewGenre(@RequestBody Genre genre) throws Exception {

        Genre genreToSave = genreService.saveGenre(genre);

        if (genreToSave == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(genre, HttpStatus.CREATED);
    }

    /**
     * This method is used to add many genres to the database, it is called when a
     * POST request is made to /genre/add-many, it expects a JSON array with the
     * genres to be added to the database.
     * 
     * @param genre The genres to be added to the database
     * 
     * @return ResponseEntity<Iterable<Genre>> This returns a JSON object with the
     *         genres that were added to the database otherwise it returns a 400 BAD
     *         REQUEST response status to indicate that the request could not be
     *         understood by the server due to malformed syntax.
     * 
     * @throws Exception If there is an error adding the genres to the database this
     *                   exception is thrown
     */
    @PostMapping(path = "/addMany")
    public ResponseEntity<Iterable<Genre>> addNewGenres(@RequestBody Iterable<Genre> genre) throws Exception {
        Iterable<Genre> savedGenres = genreService.saveManyGenres(genre);

        if (savedGenres == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(savedGenres, HttpStatus.CREATED);
    }

    /**
     * This method is used to update a genre in the database, it is called when a
     * PATCH request is made to /genre/patch/{id}, it expects a JSON object with the
     * genre to be updated.
     * 
     * @param id    The id of the genre to be updated
     * 
     * @param genre The genre to be updated
     * 
     * @return ResponseEntity<Genre> This returns a JSON object with the genre
     *         patched in the database otherwise it returns a 400 BAD REQUEST
     *         response status to indicate that the request could not be understood
     *         by the server due to malformed syntax.
     * 
     * @throws Exception If there is an error updating the genre in the database
     *                   this exception is thrown
     */
    @PatchMapping(path = "/patch/{id}")
    public ResponseEntity<Genre> patchGenre(@PathVariable Long id, @RequestBody Genre genre) throws Exception {
        Genre genreToPatch = genreService.patchGenre(id, genre);

        if (genreToPatch == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(genreToPatch, HttpStatus.OK);
    }

    /**
     * This method is used to update a genre in the database, it is called when a
     * PUT request is made to /genre/update/{id}, it expects a JSON object with the
     * genre to be updated.
     * 
     * @param id    The id of the genre to be updated
     * 
     * @param genre The genre to be updated
     * 
     * @return ResponseEntity<Genre> This returns a JSON object with the genre that
     * 
     * @throws Exception If there is an error updating the genre in the database
     *                   this exception is thrown
     */
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genre) throws Exception {

        Genre genreToUpdate = genreService.updateGenre(id, genre);

        if (genreToUpdate == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(genreToUpdate, HttpStatus.OK);
    }

    /**
     * This method is used to delete a genre from the database, it is called when a
     * DELETE request is made to /genre/delete/{id}.
     * 
     * @param id The id of the genre to be deleted
     * 
     * @return ResponseEntity<Genre> This returns a JSON object with the genre that
     *         was not found in the database, otherwise it returns a 204 NO CONTENT
     *         response status to indicate that the request has succeeded completely
     *         and that the server has no additional content to send in the
     *         response.
     * 
     * @throws Exception If there is an error deleting the genre from the database
     *                   this exception is thrown
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable Long id) throws Exception {

        Genre genre = genreService.findGenreById(id);

        if (genre == null) {
            return new ResponseEntity<>(genre, null, HttpStatus.NOT_FOUND);
        }

        genreService.deleteGenreById(id);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
