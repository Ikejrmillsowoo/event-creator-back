package Codewithike.event_creator.models.event;

// src/test/java/Codewithike/event_creator/model/UserTest.java
//package Codewithike.event_creator.model;

import Codewithike.event_creator.model.User;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void constructorAndGetters_work() {
        Date created = new Date(0L); // deterministic
        User u = new User("Alice", "alice@example.com", "secret", created);

        assertNull(u.getId());
        assertEquals("Alice", u.getName());
        assertEquals("alice@example.com", u.getEmail());
        assertEquals("secret", u.getPassword());
        assertEquals(created, u.getCreatedAt());
    }

    @Test
    void setters_updateFields() {
        User u = new User();
        Date d = new Date(123456789L);

        u.setId(42L);
        u.setName("Bob");
        u.setEmail("bob@example.com");
        u.setPassword("pwd");
        u.setCreatedAt(d);

        assertEquals(Long.valueOf(42L), u.getId());
        assertEquals("Bob", u.getName());
        assertEquals("bob@example.com", u.getEmail());
        assertEquals("pwd", u.getPassword());
        assertEquals(d, u.getCreatedAt());
    }
}
