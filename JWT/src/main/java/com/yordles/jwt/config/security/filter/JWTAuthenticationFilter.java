package com.yordles.jwt.config.security.filter;

import com.yordles.jwt.models.User;
import com.yordles.jwt.models.UserRepository;
import com.yordles.jwt.services.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // 1. Obtener el header que contiene el token
        String authHeader = request.getHeader("Authorization"); // Bearer jwt

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 2. Obtener jwt desde header
        String jwt = authHeader.split(" ")[1]; // jwt

        // 3. Obtener el subject/username desde el jwt
        String username = jwtService.extractUsername(jwt);

        // 4. Setear un objeto Authentication dentro del SecurityContext

        User user = userRepository.findByUsernameOrEmail(username, username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found with username or email: " + username)
                );
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authToken);

        // 5. Ejecutar el resto de filtros
        filterChain.doFilter(request, response);
    }
}
