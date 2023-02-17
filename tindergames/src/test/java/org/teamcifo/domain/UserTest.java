package org.teamcifo.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;


public class UserTest {
    @Test
    public void testGettersAndSetters() {
        // Create an instance of the Faker library to generate fake data
        Faker faker = new Faker();
        User user = new User();
        // Set the user's properties using fake data
        String fakeId = faker.number().digits(10);
        String fakeName = faker.name().firstName();
        String fakeLastName = faker.name().lastName();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();



        //user.setUserId(faker.number().digits(10));
        user.setUserId(fakeId);
        user.setName(fakeName);
        user.setLastName(fakeLastName);
        user.setEmail(fakeEmail);
        user.setPassword(fakePassword);

        // Check that the user's properties have been correctly set
        assertEquals(fakeId, user.getUserId());
        assertEquals(fakeName, user.getName());
        assertEquals(fakeLastName, user.getLastName());
        assertEquals(fakeEmail, user.getEmail());
        assertEquals(fakePassword, user.getPassword());

        //control gameplay & game Collection on user scope?
    }
}