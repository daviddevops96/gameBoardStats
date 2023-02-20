package org.teamcifo.logic;

import static org.junit.jupiter.api.Assertions.*;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.teamcifo.domain.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LogInTest {

    private UserManager userManager;
    private LogIn logIn;
    private List<User> users;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
        users = createFakeUsers(5);
        for (User user : users) {
            userManager.addUser(user);
        }
        logIn = new LogIn(userManager);
    }

    @Test
    void testSuccessfulLogin() {
        // Select a user from the fake users list
        User user = users.get(2);
        // Log in as the selected user
        simulateUserInput(user.getUserId(), user.getPassword());
        logIn.start();
        // Check that the menu is displayed after successful login
        assertTrue(logIn.showMenu());
    }

    @Test
    void testFailedLogin() {
        // Select a user from the fake users list
        User user = users.get(2);
        // Try to log in with a wrong password
        simulateUserInput(user.getUserId(), "wrongpassword");
        logIn.start();
        // Check that the login failed and the menu is not displayed
        assertFalse(logIn.showMenu());
    }

    @Test
    void testRegisterNewUser() {
        // Create a new fake user
        Faker faker = new Faker();
        User newUser = new User();
        newUser.setUserId(faker.number().digits(10));
        newUser.setPassword(faker.internet().password());
        newUser.setName(faker.name().firstName());

        // Try to register the new user
        simulateUserInput("2", newUser.getUserId(), newUser.getPassword(), newUser.getName());
        logIn.start();

        // Check that the registration was successful and the user is added to the user manager
        assertNotNull(userManager.getUser(newUser.getUserId()));
    }

    @Test
    void testRegisterExistingUser() {
        // Select a user from the fake users list
        User user = users.get(2);
        // Try to register a new user with the same user ID as the selected user
        simulateUserInput("2", user.getUserId(), "password", "John");
        logIn.start();
        // Check that the registration failed and the user is not added to the user manager
        assertNull(userManager.getUser("password"));
    }

    private List<User> createFakeUsers(int count) {
        List<User> fakeUsers = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setUserId(faker.number().digits(10));
            user.setPassword(faker.internet().password());
            user.setName(faker.name().firstName());
            fakeUsers.add(user);
        }
        return fakeUsers;
    }

    private void simulateUserInput(String... inputs) {
        StringBuilder inputBuilder = new StringBuilder();
        for (String input : inputs) {
            inputBuilder.append(input);
            inputBuilder.append(System.lineSeparator());
        }
        //logIn.setInputSource(() -> inputBuilder.toString());
    }

}

