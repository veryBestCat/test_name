package com.example.demo.junit.test.service;

import com.example.demo.dto.User;
import com.example.demo.service.UserSerivce;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class UserSerivceTest {
    private static final User IVAN = User.of(2, "1234", "Ivan");
    private static final User PETR = User.of(3, "1234", "Petr");

    private UserSerivce userService;

    @BeforeAll
    static void init() {
        System.out.println("Before all: ");
    }


    @BeforeEach
    void prepare() {
        System.out.println("Before each: " + this);
        userService = new UserSerivce();
    }

//    @Test
//    void loginSuccessIfUserExists() {
//        Optional<User> user = userService.login("Kirill", "245");
//
//        assertTrue(user.isPresent());
//    }

    @Test
    void testEmptyIfNoUserAdded() {
        System.out.println("Test 1: " + this);
        var users = userService.getAll();
        assertTrue(users.isEmpty(), () -> "User  list should be empty");
    }

    @Test
    void usersSizeIfUserAdded() {
        System.out.println("Test 2: " + this);
        userService.add(IVAN);
        userService.add(PETR);
        var users = userService.getAll();
        assertEquals(2, users.size());
    }

    @AfterEach
    void deleteDataFromDataBase() {
        System.out.println("After each " + this);
    }

    @AfterAll
    static void closeConnection() {
        System.out.println("After all: ");
    }

}
