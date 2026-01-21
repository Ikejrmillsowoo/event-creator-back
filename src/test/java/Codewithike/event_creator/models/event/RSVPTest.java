package Codewithike.event_creator.models.event;

// src/test/java/Codewithike/event_creator/model/RSVPTest.java
//package Codewithike.event_creator.model;

import Codewithike.event_creator.model.RSVP;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RSVPTest {

    @Test
    void settersAndGetters_work() {
        RSVP r = new RSVP();

        r.setId(1L);
        r.setEventId(2L);
        r.setUserId(3L);
        r.setResponse("Yes");
        r.setPlusOnes(false);
        r.setCreatedAt("2026-01-02T10:00:00");
        r.setUpdatedAt("2026-01-02T11:00:00");

        assertEquals(Long.valueOf(1L), r.getId());
        assertEquals(Long.valueOf(2L), r.getEventId());
        assertEquals(Long.valueOf(3L), r.getUserId());
        assertEquals("Yes", r.getResponse());
        assertFalse(r.getPlusOnes());
        assertEquals("2026-01-02T10:00:00", r.getCreatedAt());
        assertEquals("2026-01-02T11:00:00", r.getUpdatedAt());
    }
}
