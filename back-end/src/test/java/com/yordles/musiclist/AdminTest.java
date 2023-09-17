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

@SpringBootTest
public class AdminTest {

    @Autowired
    private AdminService adminService;

    @Test
    void testGetAllAdmins() throws Exception {
        // Act
        Iterable<Admin> responseEntity = adminService.findAllAdmins();

        // Assert
        assertNotNull(responseEntity);
    }

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
