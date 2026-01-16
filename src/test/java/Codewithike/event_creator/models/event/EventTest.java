package Codewithike.event_creator.models.event;

import Codewithike.event_creator.model.event.Event;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class EventsTest {

    @Test
    void constructor_setsAllFields() {
        Event event = new Event(
                1L,
                "Party",
                "Birthday party",
                "2026-01-01",
                "18:00",
                "21:00",
                "My House",
                "2026-01-01T10:00:00",
                "2026-01-01T12:00:00",
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );

        assertEquals(Long.valueOf(1L), event.getHostUserId());
        assertEquals("Party", event.getTitle());
        assertEquals("Birthday party", event.getDescription());
        assertEquals("2026-01-01", event.getEventDate());
        assertEquals("18:00", event.getStartTime());
        assertEquals("21:00", event.getEndTime());
        assertEquals("My House", event.getLocation());
        assertEquals("2026-01-01T10:00:00", event.getCreatedAt());
        assertEquals("2026-01-01T12:00:00", event.getUpdatedAt());
        assertNotNull(event.getInvitations());
        assertNotNull(event.getRsvps());
        assertNotNull(event.getComments());
        assertTrue(event.getInvitations().isEmpty());
        assertTrue(event.getRsvps().isEmpty());
        assertTrue(event.getComments().isEmpty());
    }

    @Test
    void setters_updateFields() {
        Event event = new Event(
                2L,
                "Initial",
                "Initial desc",
                "2026-02-02",
                "09:00",
                "10:00",
                "Initial location",
                "2026-02-01T00:00:00",
                "2026-02-01T01:00:00",
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );

        event.setTitle("Updated Title");
        event.setDescription("Updated desc");
        event.setLocation("Updated location");
        event.setStartTime("08:00");
        event.setEndTime("09:00");

        assertEquals("Updated Title", event.getTitle());
        assertEquals("Updated desc", event.getDescription());
        assertEquals("Updated location", event.getLocation());
        assertEquals("08:00", event.getStartTime());
        assertEquals("09:00", event.getEndTime());
    }
}

