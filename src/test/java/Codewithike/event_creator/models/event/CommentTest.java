package Codewithike.event_creator.models.event;

// src/test/java/Codewithike/event_creator/model/CommentTest.java

import Codewithike.event_creator.model.Comment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    @Test
    void settersAndGetters_work() {
        Comment c = new Comment();

        c.setId(5L);
        c.setEventId(6L);
        c.setUserId(7L);
        c.setMessage("Hello world");
        c.setCreatedAt("2026-01-03T12:00:00");
        c.setUpdatedAt("2026-01-03T12:30:00");

        assertEquals(Long.valueOf(5L), c.getId());
        assertEquals(Long.valueOf(6L), c.getEventId());
        assertEquals(Long.valueOf(7L), c.getUserId());
        assertEquals("Hello world", c.getMessage());
        assertEquals("2026-01-03T12:00:00", c.getCreatedAt());
        assertEquals("2026-01-03T12:30:00", c.getUpdatedAt());
    }
}