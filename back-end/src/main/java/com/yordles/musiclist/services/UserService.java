package com.yordles.musiclist.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yordles.musiclist.services.repositories.UserRepository;
import com.yordles.musiclist.dtos.CreateUserDTO;
import com.yordles.musiclist.dtos.UserDTO;
import com.yordles.musiclist.dtos.interfaces.CreateUserMapper;
import com.yordles.musiclist.dtos.interfaces.UserMapper;
import com.yordles.musiclist.models.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public UserDTO findUserByUsername(String username) {

        User user = userRepository.findByUsername(username);

        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    @Transactional
    public Set<User> findUserByIds(Set<Long> ids) {
        Set<User> userSet = new HashSet<>();
        userRepository.findAllById(ids).forEach(userSet::add);
        return userSet;
    }

    @Transactional
    public UserDTO saveUser(CreateUserDTO user) {

        User userToSave = CreateUserMapper.INSTANCE.createUserDTOToUser(user);

        user.setPassword(encodePassword(userToSave.getPassword()));
        return UserMapper.INSTANCE.userToUserDTO(userRepository.save(userToSave));
    }

    @Transactional
    public Iterable<User> saveManyUsers(Iterable<User> users) {
        users.forEach(user -> user.setPassword(encodePassword(user.getPassword())));
        return userRepository.saveAll(users);
    }

    @Transactional
    public User updateUser(Long id, User user) {
        User userToUpdate = findUserById(id);

        userToUpdate.setCreateTime(user.getCreateTime());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(encodePassword(user.getPassword()));
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setVerified(user.isVerified());

        return userRepository.save(userToUpdate);
    }

    @Transactional
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
