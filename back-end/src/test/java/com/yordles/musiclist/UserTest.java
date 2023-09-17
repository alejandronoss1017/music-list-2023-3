package com.yordles.musiclist;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yordles.musiclist.models.User;
import com.yordles.musiclist.services.UserService;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    void testGetAllUsers() throws Exception {
        // Act
        Iterable<User> responseEntity = userService.findAllUsers();

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testGetUsersById() throws Exception {
        // Arrange
        Long UserId = 1L;

        // Act
        User responseEntity = userService.findUserById(UserId);

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testAddNewUser() throws Exception {
        // Arrange
        User userToSave = new User();
        userToSave.setEmail("TestNewUser");
        userToSave.setUsername("TestUsernameNewUser");
        userToSave.setPassword("TestPasswordNewUser");

        // Act
        User responseEntity = userService.saveUser(userToSave);

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testUpdateUser() {
        // Arrange
        Long idToUpdate = 1L;

        User userToSave = new User();
        userToSave.setEmail("TestUpdateUser");
        userToSave.setUsername("TestUsernameUpdateUser");
        userToSave.setPassword("TestPasswordUpdateUser");

        // Act
        User responseEntity = userService.updateUser(idToUpdate, userToSave);

        // Assert
        assertNotNull(responseEntity);
    }

    @Test
    void testDeleteUser() {
        // Arrange
        Long idToDelete = 1L;

        // Act
        userService.deleteUserById(idToDelete);

        // Assert
        User deletedUser = userService.findUserById(idToDelete);
        assertNull(deletedUser);
    }
}
