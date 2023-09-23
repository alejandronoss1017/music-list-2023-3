package com.yordles.musiclist;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yordles.musiclist.models.Admin;
import com.yordles.musiclist.services.AdminService;

/**
 *
 * @name AdminTest
 *
 * @description This class tests the AdminService class.
 * @see com.yordles.musiclist.services.AdminService
 * @version 1.0
 *
 * @since 2023-09-22
 *
 */
@SpringBootTest
public class AdminTest {

    @Autowired
    private AdminService adminService; // This annotation tells Spring to inject an instance of AdminService here.

    /**
     *
     * @name testGetAllAdmins
     *
     * @description This method tests the getAllAdmins method from the AdminService class.
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
    void testGetAllAdmins() throws Exception {
        // Act
        Iterable<Admin> responseEntity = adminService.findAllAdmins();

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testGetAdminsById
     *
     * @description This method tests the getAdminsById method from the AdminService class.
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
    void testGetAdminsByIds() throws Exception {
        // Arrange
        Set<Long> idSet = new HashSet<>();
        idSet.add(1L);
        idSet.add(2L);

        // Act
        Set<Admin> responseEntity = adminService.findAdminByIds(idSet);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testAddNewAdmin
     *
     * @description This method tests the addNewAdmin method from the AdminService class.
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
    void testAddNewAdmin() throws Exception {
        // Arrange
        Admin adminToSave = new Admin();
        adminToSave.setEmail("test@example.com");
        adminToSave.setUsername("testUser");
        adminToSave.setPassword("testPassword");

        // Act
        Admin responseEntity = adminService.saveAdmin(adminToSave);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testUpdateAdmin
     *
     * @description This method tests the updateAdmin method from the AdminService class.
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
    void testUpdateAdmin() {
        // Arrange
        Long idToUpdate = 1L;

        Admin adminToSave = new Admin();
        adminToSave.setEmail("testUpdate@example.com");
        adminToSave.setUsername("testUserUpdate");
        adminToSave.setPassword("testPasswordUpdate");

        // Act
        Admin responseEntity = adminService.updateAdmin(idToUpdate, adminToSave);

        // Assert
        assertNotNull(responseEntity);
    }

    /**
     *
     * @name testDeleteAdmin
     *
     * @description This method tests the deleteAdminById method from the AdminService class.
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
    void testDeleteAdmin() {
        // Arrange
        Long idToDelete = 1L;

        // Act
        adminService.deleteAdminById(idToDelete);

        // Assert
        Admin deletedAdmin = adminService.findAdminById(idToDelete);
        assertNull(deletedAdmin);
    }
}
