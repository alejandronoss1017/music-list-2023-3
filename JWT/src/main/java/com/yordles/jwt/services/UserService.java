package com.yordles.jwt.services;

import com.yordles.jwt.models.User;
import com.yordles.jwt.models.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @class: UserService
 * @description: This class is used to handle the user requests
 * @annotations:
 * @Service for Spring to detect this class as a service
 * @RequiredArgsConstructor for Lombok to generate a constructor with the
 *                          required arguments
 */
@Service
@RequiredArgsConstructor
public class UserService {

    // @Autowired for Spring to inject the dependencies
    @Autowired
    // PasswordEncoder for Spring to detect this class as a component
    private final PasswordEncoder passwordEncoder;
    // @Autowired for Spring to inject the dependencies
    @Autowired
    // UserRepository for Spring to detect this class as a component
    UserRepository userRepository;

    /**
     * @param id
     * @return User
     * @name: findUserById
     * @description: This method is used to find a user by its id
     * @annotations:
     * @Transactional for Spring to detect this method as a transactional method
     */
    @Transactional
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * @param ids
     * @return Set<User>
     * @name: findUserByIds
     * @description: This method is used to find a set of users by their ids
     * @annotations:
     * @Transactional for Spring to detect this method as a transactional method
     */
    @Transactional
    public Set<User> findUserByIds(Set<Long> ids) {
        Set<User> userSet = new HashSet<>();
        userRepository.findAllById(ids).forEach(userSet::add);
        return userSet;
    }

    /**
     * @param User
     * @return User
     * @name: saveUser
     * @description: This method is used to save a user
     * @annotations:
     * @Transactional for Spring to detect this method as a transactional method
     */
    @Transactional
    public User saveUser(User User) {
        User.setPassword(encodePassword(User.getPassword()));
        return userRepository.save(User);
    }

    /**
     * @param users
     * @return Iterable<User>
     * @name: saveManyUsers
     * @description: This method is used to save a set of users
     * @annotations:
     * @Transactional for Spring to detect this method as a transactional method
     */
    @Transactional
    public Iterable<User> saveManyUsers(Iterable<User> users) {
        users.forEach(user -> user.setPassword(encodePassword(user.getPassword())));
        return userRepository.saveAll(users);
    }

    /**
     * @param id
     * @name: deleteUserById
     * @description: This method is used to delete a user by its id
     * @annotations:
     * @Transactional for Spring to detect this method as a transactional method
     */
    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * @param password
     * @return String
     * @name: encodePassword
     * @description: This method is used to encode a password
     */
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
