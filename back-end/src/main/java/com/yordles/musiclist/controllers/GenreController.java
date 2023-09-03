package com.yordles.musiclist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yordles.musiclist.models.Genre;
import com.yordles.musiclist.services.GenreService;

/**
 * This class is a controller class that will handle the HTTP requests related
 * to genres. This class will typically interact with the service class to get
 * the data from the database and return it to the client in the form of a JSON
 * object.
 * 
 * Endpoints:
 * 
 * 1. GET /genre/all: This endpoint is used to get all the genres from the
 * database.
 * 
 * 2. POST /genre/add: This endpoint is used to add a new genre to the database.
 * 
 * 
 * @Controller: This annotation is used to mark the class as a controller class.
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
 */
@Controller
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
     *         the genres
     * @throws Exception If there is an error getting the genres from the database
     *                   this exception is thrown
     */
    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<Genre>> getAllGenres() throws Exception {

        // 1. ResponseEntity: This is the main class that represents an HTTP response.
        // It's used to encapsulate the response status, headers, and body.
        //
        // 2. <String>: This is the type parameter. It specifies the type of the
        // response body. In this case, it's a String, indicating that the response
        // body will be a string.
        return ResponseEntity.ok().body(genreService.findAllGenres());
    }

    /**
     * This method is used to add a new genre to the database, it is called when a
     * POST request is made to /genre/add, it expects a JSON object with the name of
     * the genre.
     * 
     * @param genre The genre to be added to the database
     * @return ResponseEntity<String> This returns a string with the status of the
     *         request
     * @throws Exception If there is an error adding the genre to the database this
     *                   exception is thrown
     */
    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewGenre(@RequestBody Genre genre) throws Exception {

        // 1. ResponseEntity: This is the main class that represents an HTTP response.
        // It's used to encapsulate the response status, headers, and body.
        //
        // 2. <String>: This is the type parameter. It specifies the type of the
        // response body. In this case, it's a String, indicating that the response
        // body will be a string.
        genreService.saveGenre(genre);
        return ResponseEntity.ok().body("Saved");
    }

}
