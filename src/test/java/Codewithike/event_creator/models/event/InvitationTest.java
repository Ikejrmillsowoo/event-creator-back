package Codewithike.event_creator.models.event;

// src/test/java/Codewithike/event_creator/model/InvitationTest.java

import Codewithike.event_creator.model.Invitation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvitationTest {

    @Test
    void settersAndGetters_work() {
        Invitation inv = new Invitation();

        inv.setId(10L);
        inv.setEventId(20L);
        inv.setEmail("test@example.com");
        inv.setInvitedUserId(30L);
        inv.setStatus("pending");
        inv.setToken("tok-123");
        inv.setCreatedAt("2026-01-01T00:00:00");
        inv.setUpdatedAt("2026-01-01T01:00:00");

        assertEquals(Long.valueOf(10L), inv.getId());
        assertEquals(Long.valueOf(20L), inv.getEventId());
        assertEquals("test@example.com", inv.getEmail());
        assertEquals(Long.valueOf(30L), inv.getInvitedUserId());
        assertEquals("pending", inv.getStatus());
        assertEquals("tok-123", inv.getToken());
        assertEquals("2026-01-01T00:00:00", inv.getCreatedAt());
        assertEquals("2026-01-01T01:00:00", inv.getUpdatedAt());
    }
}