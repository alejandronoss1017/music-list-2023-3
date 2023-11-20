package com.yordles.musiclist;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yordles.musiclist.models.User;
import com.yordles.musiclist.services.UserService;

/**
 *
 * @name UserTest
 *
 * @description This class tests the UserService class.
 * @see com.yordles.musiclist.services.UserService
 * @version 1.0
 *
 * @since 2023-09-22
 *
 */
@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService; // This annotation tells Spring to inject an instance of UserService here.

    /**
     *
     * @name testGetAllUsers
     *
     * @description This method tests the getAllUsers method from the UserService class.
     * @param none
     * @return none
     * @throws Exception
     *
     * @by Carlos Rojas
     * @version 1.0
     * @Review by Stiven Ortiz
     * @State Tested [PASS]
     *
     * @since 2023-09-22
     *
     */
    @Test
    void testGetAllUsers() throws Exception {
        // Act
        Iterable<User> responseEntity = userService.findAllUsers();

        // Assert
        assertNotNull(responseEntity);
    }


    /**
     *
     * @name testGetAllUsers
     *
     * @description This method tests the getAllUsers method from the UserService class.
     * @param none
     * @return none
     * @throws Exception
     *
     * @by Carlos Rojas
     * @version 1.0
     * @Review by Stiven Ortiz
     * @State Tested [PASS]
     *
     * @since 2023-09-22
     *
     */
    @Test
    void testGetUsersById() throws Exception {
        // Arrange
        Long UserId = 1L;

        // Act
        User responseEntity = userService.findUserById(UserId);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testAddNewUser
     *
     * @description This method tests the addNewUser method from the UserService class.
     * @param none
     * @return none
     * @throws Exception
     *
     * @by Carlos Rojas
     * @version 1.0
     * @Review by Stiven Ortiz
     * @State Tested [PASS]
     *
     * @since 2023-09-22
     *
     */
    // @Test
    // void testAddNewUser() throws Exception {
    //     // Arrange
    //     User userToSave = new User();
    //     userToSave.setEmail("TestNewUser");
    //     userToSave.setUsername("TestUsernameNewUser");
    //     userToSave.setPassword("TestPasswordNewUser");

    //     // Act
    //     User responseEntity = userService.saveUser(userToSave);

    //     // Assert
    //     assertNotNull(responseEntity);
    // }

    /**
     *
     * @name testUpdateUser
     *
     * @description This method tests the updateUser method from the UserService class.
     * @param none
     * @return none
     * @throws Exception
     *
     * @by Carlos Rojas
     * @version 1.0
     * @Review by Stiven Ortiz
     * @State Tested [PASS]
     *
     * @since 2023-09-22
     *
     */
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

    /**
     *
     * @name testDeleteUser
     *
     * @description This method tests the deleteUser method from the UserService class.
     * @param none
     * @return none
     * @throws Exception
     *
     * @by Carlos Rojas
     * @version 1.0
     * @Review by Stiven Ortiz
     * @State Tested [PASS]
     *
     * @since 2023-09-22
     *
     */
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
