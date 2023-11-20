package com.yordles.jwt.config.security;

import com.yordles.jwt.config.security.filter.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Component
@EnableWebSecurity
public class HttpSecurityConfig {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JWTAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .sessionManagement(
                        sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authConfig ->
                        {
                            authConfig.requestMatchers(HttpMethod.POST, "/login").permitAll();
                            authConfig.requestMatchers(HttpMethod.POST, "/register").permitAll();
                            authConfig.requestMatchers(HttpMethod.POST, "/registerAdmin").permitAll();
                            authConfig.requestMatchers("/error").permitAll();

                            authConfig.requestMatchers(HttpMethod.GET, "/verifyRoleUser").hasAuthority("ROLE_USER");
                            authConfig.requestMatchers(HttpMethod.GET, "/verifyRoleAdmin").hasAuthority("ROLE_ADMIN");

                            authConfig.anyRequest().denyAll();
                        }
                );
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // Permitir solicitudes desde cualquier origen
        configuration.addAllowedMethod("*"); // Permitir cualquier método (GET, POST, PUT, DELETE, etc.)
        configuration.addAllowedHeader("*"); // Permitir cualquier encabezado

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
