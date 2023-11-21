package com.yordles.jwt.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @class: User
 * @description: This class is used to store the user information in the
 *               database
 * @annotations:
 * @Entity for Spring to detect this class as a table in the database
 * @Getter for Lombok to generate the getters
 * @Setter for Lombok to generate the setters
 */
@Getter
@Entity
public class User implements UserDetails {

    // @Id for Spring to detect this attribute as the primary key
    @Id
    // @GeneratedValue for Spring to generate the value of the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id for the user
    private int id;

    // @Setter for Lombok to generate the setters
    @Setter
    // @Column for Spring to detect this attribute as a column in the database
    @Column(nullable = false)
    private String email;

    // @Setter for Lombok to generate the setters
    @Setter
    // @Column for Spring to detect this attribute as a column in the database
    @Column(nullable = false)
    // password for the user
    private String password;

    // @Column for Spring to detect this attribute as a column in the database
    @Column(nullable = false)
    // username for the user
    private String username;

    // Column for Spring to detect this attribute as a column in the database
    @Column(nullable = false)
    // admin for the user
    private int admin;

    /**
     * @name: User
     * @description: This method is used to create an empty user
     */
    public User() {
        super();
        this.username = null;
        this.email = null;
        this.password = null;
    }

    /**
     * @param email
     * @param password
     * @param username
     * @name: User
     * @description: This method is used to create a user with the given parameters
     */
    public User(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
        this.admin = 0;
    }

    public static User createAdmin(String username, String email, String password) {
        User user = new User(username, email, password);
        user.admin = 1;
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = null;

        if (this.admin == 1)
            authorities = List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        else
            authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
