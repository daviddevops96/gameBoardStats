package org.teamcifo.logic;

import static org.junit.jupiter.api.Assertions.*;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.teamcifo.domain.User;
import java.util.HashMap;
import java.util.Map;

public class UserManagerTest {
    @Test
    public void testAddUserAndGetUser() {
        // Create an instance of the Faker library to generate fake data
        Faker faker = new Faker();
        UserManager userManager = new UserManager();
        User user = new User();
        String fakeId = faker.number().digits(10);
        user.setUserId(fakeId);
        user.setName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());

        // Add the user to the user manager
        userManager.addUser(user);

        // Get the user from the user manager and check that it is the same as the user that was added
        User retrievedUser = userManager.getUser(fakeId);
        assertEquals(user, retrievedUser);
    }

    @Test
    public void testAuthenticate() {
        // Create an instance of the Faker library to generate fake data
        Faker faker = new Faker();
        UserManager userManager = new UserManager();
        User user = new User();
        String fakeId = faker.number().digits(10);
        user.setUserId(fakeId);
        user.setName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        String fakePassword = faker.internet().password();
        user.setPassword(fakePassword);


        // Add the user to the user manager
        userManager.addUser(user);

        // Authenticate the user and check that the result is true
        boolean result = userManager.authenticate(fakeId, fakePassword);
        assertTrue(result);
    }

    @Test
    public void testGetAllUsers() {
        // Create an instance of the Faker library to generate fake data
        Faker faker = new Faker();
        UserManager userManager = new UserManager();
        Map<String,User> users = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserId(faker.number().digits(10));
            user.setName(faker.name().firstName());
            user.setLastName(faker.name().lastName());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            users.put(user.getUserId(),user);
            userManager.addUser(user);
        }

        // Get the list of all users from the user manager and check that it is the same as the list of users that was created
        Map<String,User> retrievedUsers = userManager.getAllUsers();
        assertEquals(users,retrievedUsers);

    }
}