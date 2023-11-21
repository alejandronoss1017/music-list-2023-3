package com.yordles.musiclist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yordles.musiclist.dtos.CreateUserDTO;
import com.yordles.musiclist.dtos.UserDTO;
import com.yordles.musiclist.models.User;
import com.yordles.musiclist.services.UserService;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * This method is used to get all the users from the database, it is called
     * when a GET request is made to /user/all, it returns a JSON object with all
     * the users.
     * 
     * @return ResponseEntity<Iterable<User>> This returns a JSON object with all
     *         the users otherwise it returns a 404 NOT FOUND response status to
     *         indicate that the requested resource could not be found.
     * 
     * @throws Exception If there is an error getting the users from the database
     *                   this exception is thrown
     */
    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<User>> getAllUsers() throws Exception {

        Iterable<User> user = userService.findAllUsers();

        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // 1. ResponseEntity: This is the main class that represents an HTTP response.
        // It's used to encapsulate the response status, headers, and body.
        //
        // 2. <>: This is the type parameter. It specifies the type of the
        // response body. It can be inferred by the compiler.
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * This method is used to get a user by its id, it is called when a GET request
     * is made to /user/{id}, it returns a JSON object with the user.
     * 
     * @param id The id of the user to be retrieved
     * 
     * @return ResponseEntity<User> This returns a JSON object with the user
     *         otherwise it returns a 404 NOT FOUND response status to indicate that
     *         the requested resource could not be found.
     * 
     * @throws Exception If there is an error getting the user from the database
     *                   this exception is thrown
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws Exception {

        User user = userService.findUserById(id);

        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/username/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) throws Exception {

        UserDTO user = userService.findUserByUsername(username);

        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * This method is used to add a new user to the database, it is called when a
     * POST request is made to /user/add, it expects a JSON object with the name of
     * the user.
     * 
     * @param user The user to be added to the database
     * @return ResponseEntity<User> This returns a JSON object with the user that
     *         was added to the database
     * @throws Exception If there is an error adding the user to the database this
     *                   exception is thrown
     */
    @PostMapping(path = "/add")
    public ResponseEntity<UserDTO> addNewUser(@RequestBody CreateUserDTO user) throws Exception {

        UserDTO userToSave = userService.saveUser(user);

        if (userToSave == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userToSave, HttpStatus.CREATED);
    }

    /**
     * This method is used to update a user in the database, it is called when a
     * PUT request is made to /user/update/{id}, it expects a JSON object with the
     * user to be updated.
     * 
     * @param id   The id of the user to be updated
     * 
     * @param user The user to be updated
     * 
     * @return ResponseEntity<user> This returns a JSON object with the user that
     * 
     * @throws Exception If there is an error updating the user in the database
     *                   this exception is thrown
     */
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<User> updateuser(@PathVariable Long id, @RequestBody User user) throws Exception {

        User userToUpdate = userService.updateUser(id, user);

        if (userToUpdate == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
    }

    /**
     * This method is used to delete a user from the database, it is called when a
     * DELETE request is made to /user/delete/{id}.
     * 
     * @param id The id of the user to be deleted
     * 
     * @return ResponseEntity<user> This returns a JSON object with the user that
     *         was not found in the database, otherwise it returns a 204 NO CONTENT
     *         response status to indicate that the request has succeeded completely
     *         and that the server has no additional content to send in the
     *         response.
     * 
     * @throws Exception If there is an error deleting the user from the database
     *                   this exception is thrown
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) throws Exception {

        User user = userService.findUserById(id);

        if (user == null) {
            return new ResponseEntity<>(user, null, HttpStatus.NOT_FOUND);
        }

        // Delete the user
        userService.deleteUserById(id);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
