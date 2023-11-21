package com.yordles.jwt.controllers;

import com.yordles.jwt.DTO.AuthenticationRequest;
import com.yordles.jwt.DTO.AuthenticationResponse;
import com.yordles.jwt.DTO.UserDTO;
import com.yordles.jwt.models.User;
import com.yordles.jwt.services.AuthenticationService;
import com.yordles.jwt.services.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse jwtDto = authenticationService.login(authenticationRequest);

        return ResponseEntity.ok().body(jwtDto);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        if (userDTO.getUsername() == null || userDTO.getPassword() == null || userDTO.getEmail() == null)
            return ResponseEntity.badRequest().body("Username, password and email are required");

        User userToSave = userService.saveUser(
                new User(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword()));

        if (userToSave == null)
            return ResponseEntity.badRequest().body("Username or email already exists");

        return ResponseEntity.ok().body("User registered successfully");
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<String> registerAdmin(@RequestBody UserDTO userDTO) {
        if (userDTO.getUsername() == null || userDTO.getPassword() == null || userDTO.getEmail() == null)
            return ResponseEntity.badRequest().body("Username, password and email are required");

        User userToSave = userService.saveUser(User.createAdmin(userDTO.getUsername(),
                userDTO.getEmail(), userDTO.getPassword()));

        if (userToSave == null)
            return ResponseEntity.badRequest().body("Username or email already exists");

        return ResponseEntity.ok().body("User registered successfully");
    }

    @GetMapping("/verifyRoleUser")
    public ResponseEntity<?> verifyRoleUser() {
        Map<String, Boolean> role = new HashMap<>();
        role.put("User", true);
        return ResponseEntity.ok(role);
    }

    @GetMapping("/verifyRoleAdmin")
    public ResponseEntity<?> verifyRoleAdmin() {
        Map<String, Boolean> role = new HashMap<>();
        role.put("Admin", true);
        return ResponseEntity.ok(role);
    }
}
