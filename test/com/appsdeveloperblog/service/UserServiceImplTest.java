package com.appsdeveloperblog.service;

import com.appsdeveloperblog.io.UsersDatabase;
import com.appsdeveloperblog.io.UsersDatabaseMapImpl;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {

    UserService userService;
    UsersDatabase usersDatabase;
    String createdUserId= "";
    @BeforeAll
    void setup() {
        // Create & initialize database
        usersDatabase = new UsersDatabaseMapImpl();
        usersDatabase.init();
        userService = new UserServiceImpl(usersDatabase);


    }

    @AfterAll
    void cleanup() {
        // Close connection

        usersDatabase.close();
        // Delete database
    }

    @Test
    @Order(1)
    @DisplayName("Create User works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {
        Map<String, String> user = new HashMap<>();
        user.put("firtsName", "Utkarsh");
        user.put("lastName", "Sinh");

        createdUserId = userService.createUser(user);
        assertNotNull(createdUserId, "User id should not be null");

    }


    @Test
    @Order(2)
    @DisplayName("Update user works")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() {
        Map<String, String> newUserDetails = new HashMap<>();
        newUserDetails.put("firstName", "Mitthu");
        newUserDetails.put("lastName", "Sinh");

        Map updatedUserDetails = userService.updateUser(createdUserId, newUserDetails);
        assertEquals(newUserDetails.get("firstName"), updatedUserDetails.get("firstName"), "Returned Values of user's firstname is incorrect");
        assertEquals(newUserDetails.get("lastName"), updatedUserDetails.get("lastName"), "Returned Values of user's lastname is incorrect");

    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void testGetUserDetails_whenProvidedWithValidUserId_returnsUserDetails() {
        Map userDetails = userService.getUserDetails(createdUserId);
        assertNotNull(userDetails, "User id is present");
        assertEquals(createdUserId, userDetails.get("userId"), "Returned user details contains incorrect user id");

    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void testDeleteUser_whenProvidedWithValidUserId_returnsUserDetails() {
        userService.deleteUser(createdUserId);
        assertNull(userService.getUserDetails(createdUserId), "User Should not be found");

    }

}
