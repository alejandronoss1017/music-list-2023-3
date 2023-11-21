package com.yordles.musiclist.services.repositories;

import org.springframework.data.repository.CrudRepository;

import com.yordles.musiclist.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

    User findByUsername(String username);
}
