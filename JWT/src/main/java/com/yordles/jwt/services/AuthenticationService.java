package com.yordles.jwt.services;

import com.yordles.jwt.DTO.AuthenticationRequest;
import com.yordles.jwt.DTO.AuthenticationResponse;
import com.yordles.jwt.models.User;
import com.yordles.jwt.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                );

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        User user = userRepository.findByUsernameOrEmail(
                        authenticationRequest.getUsername(), authenticationRequest.getUsername())
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found with username or email: " +
                                authenticationRequest.getUsername())
                );

        String jwt = jwtService.generateToken(user, generateExtraClaims(user));

        return new AuthenticationResponse(jwt);
    }

    private Map<String, Object> generateExtraClaims(User user) {
        return Map.of(
                "username", user.getUsername(),
                "admin", user.getAdmin()
        );
    }
}
