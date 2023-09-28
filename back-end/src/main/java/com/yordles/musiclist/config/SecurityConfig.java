package com.yordles.musiclist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // Declaration of the password encoder bean
    // This bean is used to encode passwords

    // Bean used to use lombok's @RequiredArgsConstructor

    @Bean
    public PasswordEncoder passwordEncoder() {

        // Set the strength of the encryption. Default is 10
        // The higher the number the more secure, but slower

        // int customStrength = 10;

        return new BCryptPasswordEncoder();
    }
}
