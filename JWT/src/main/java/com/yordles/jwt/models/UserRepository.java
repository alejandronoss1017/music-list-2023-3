package com.yordles.jwt.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @interface: UserRepository
 * @description: This interface is used to interact with the database
 * @extends: CrudRepository for Spring to detect this interface as a repository and execute the methods
 */
public interface UserRepository extends CrudRepository<User, Long> {
    /**
     * @param username
     * @return User
     * @name: findByUsername
     * @description: This method is used to find a user by its username
     */
    @Transactional
    Optional<User> findByUsernameOrEmail(String username, String email);
}
