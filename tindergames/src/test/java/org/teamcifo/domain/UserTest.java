package org.teamcifo.domain;

import static org.junit.jupiter.api.Assertions.*;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


public class UserTest {

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        Faker faker = new Faker();

        // Generate fake data for the user object
        String fakeId = faker.number().digits(10);
        String fakeName = faker.name().firstName();
        String fakeLastName = faker.name().lastName();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();

        // Set the user object's properties with fake data
        user.setUserId(fakeId);
        user.setName(fakeName);
        user.setLastName(fakeLastName);
        user.setEmail(fakeEmail);
        user.setPassword(fakePassword);
        user.setUserGameCollection(new GamesCollection());
        user.setGamePlays(new ArrayList<GamePlay>());

        // Assert that the user object's properties have been set with the correct fake data
        assertEquals(user.getName(), fakeName);
        assertEquals(user.getLastName(), fakeLastName);
        assertEquals(user.getEmail(), fakeEmail);
        assertEquals(user.getPassword(), fakePassword);
        assertEquals(user.getUserId(), fakeId);
        assertEquals(user.getUserGameCollection(), user.getUserGameCollection());
        assertEquals(user.getGamePlays(), user.getGamePlays());
    }

    @Test
    public void testNoArgsConstructor() {
        // Test that the no-args constructor creates a non-null user object
        User user = new User();
        assertNotNull(user);
    }

    @Test
    public void testAllArgsConstructor() {
        Faker faker = new Faker();
        // Test that the all-args constructor creates a non-null user object
        User user = new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),
                faker.internet().password(), faker.number().digits(10), new GamesCollection(), new ArrayList<GamePlay>());
        assertNotNull(user);
    }

    @Test
    public void testToString() {
        Faker faker = new Faker();
        // Test that the toString() method does not return null
        User user = new User(faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress(),
                faker.internet().password(), faker.number().digits(10), new GamesCollection(), new ArrayList<GamePlay>());
        assertNotNull(user.toString());
    }

}