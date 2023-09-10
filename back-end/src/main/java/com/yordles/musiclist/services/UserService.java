package com.yordles.musiclist.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yordles.musiclist.services.repositories.UserRepository;
import com.yordles.musiclist.models.User;


import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    @Transactional
    public Set<User> findUserByIds(Set<Long> ids) {
        Set<User> userSet = new HashSet<>();
        userRepository.findAllById(ids).forEach(userSet::add);
        return userSet;
    }

    @Transactional
    public User saveUser(User User) {
        return userRepository.save(User);
    }

    @Transactional
    public Iterable<User> saveManyUsers(Iterable<User> users) {
        return userRepository.saveAll(users);
    }


    @Transactional
    public User updateUser(Long id, User user) {
        User userToUpdate = findUserById(id);

        userToUpdate.setCreateTime(user.getCreateTime());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setVerified(user.isVerified());

        return userRepository.save(userToUpdate);
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
