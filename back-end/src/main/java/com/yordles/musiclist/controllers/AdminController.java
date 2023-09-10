package com.yordles.musiclist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yordles.musiclist.models.Admin;
import com.yordles.musiclist.services.AdminService;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    
     @Autowired
    private AdminService adminService;
    
     /**
     * This method is used to get all the admins from the database, it is called
     * when a GET request is made to /admin/all, it returns a JSON object with all
     * the admins.
     * 
     * @return ResponseEntity<Iterable<Admin>> This returns a JSON object with all
     *         the admins otherwise it returns a 404 NOT FOUND response status to
     *         indicate that the requested resource could not be found.
     * 
     * @throws Exception If there is an error getting the admins from the database
     *                   this exception is thrown
     */
    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<Admin>> getAlladmins() throws Exception {

        Iterable<Admin> admin = adminService.findAllAdmins();

        if (admin == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        // 1. ResponseEntity: This is the main class that represents an HTTP response.
        // It's used to encapsulate the response status, headers, and body.
        //
        // 2. <>: This is the type parameter. It specifies the type of the
        // response body. It can be inferred by the compiler.
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

     /**
     * This method is used to get a admin by its id, it is called when a GET request
     * is made to /admin/{id}, it returns a JSON object with the admin.
     * 
     * @param id The id of the admin to be retrieved
     * 
     * @return ResponseEntity<admin> This returns a JSON object with the admin
     *         otherwise it returns a 404 NOT FOUND response status to indicate that
     *         the requested resource could not be found.
     * 
     * @throws Exception If there is an error getting the admin from the database
     *                   this exception is thrown
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Admin> getadminById(@PathVariable Long id) throws Exception {

        Admin admin = adminService.findAdminById(id);

        if (admin == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    /**
     * This method is used to add a new admin to the database, it is called when a
     * POST request is made to /admin/add, it expects a JSON object with the name of
     * the admin.
     * 
     * @param admin The admin to be added to the database
     * @return ResponseEntity<admin> This returns a JSON object with the admin that
     *         was added to the database
     * @throws Exception If there is an error adding the admin to the database this
     *                   exception is thrown
     */
    @PostMapping(path = "/add")
    public ResponseEntity<Admin> addNewadmin(@RequestBody Admin admin) throws Exception {

        Admin adminToSave = adminService.saveAdmin(admin);

        if (adminToSave == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(adminToSave, HttpStatus.CREATED);
    }

    /**
     * This method is used to update a admin in the database, it is called when a
     * PUT request is made to /admin/update/{id}, it expects a JSON object with the
     * admin to be updated.
     * 
     * @param id    The id of the admin to be updated
     * 
     * @param admin The admin to be updated
     * 
     * @return ResponseEntity<Admin> This returns a JSON object with the admin that
     * 
     * @throws Exception If there is an error updating the admin in the database
     *                   this exception is thrown
     */
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Admin> updateadmin(@PathVariable Long id, @RequestBody Admin admin) throws Exception {

        Admin adminToUpdate = adminService.updateadmin(id, admin);

        if (adminToUpdate == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(adminToUpdate, HttpStatus.OK);
    }


    /**
     * This method is used to delete a admin from the database, it is called when a
     * DELETE request is made to /admin/delete/{id}.
     * 
     * @param id The id of the admin to be deleted
     * 
     * @return ResponseEntity<admin> This returns a JSON object with the admin that
     *         was not found in the database, otherwise it returns a 204 NO CONTENT
     *         response status to indicate that the request has succeeded completely
     *         and that the server has no additional content to send in the
     *         response.
     * 
     * @throws Exception If there is an error deleting the admin from the database
     *                   this exception is thrown
     */
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Admin> deleteadmin(@PathVariable Long id) throws Exception {

        Admin admin = adminService.findAdminById(id);

        if (admin == null) {
            return new ResponseEntity<>(admin, null, HttpStatus.NOT_FOUND);
        }
    
        // Delete the admin
        adminService.deleteAdminById(id);

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
