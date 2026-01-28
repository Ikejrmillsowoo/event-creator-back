package Codewithike.event_creator.controller;

import Codewithike.event_creator.model.Invitation;
import Codewithike.event_creator.model.User;
import Codewithike.event_creator.model.event.Event;
import Codewithike.event_creator.repository.EventRepo;
import Codewithike.event_creator.service.InvitationService;
import Codewithike.event_creator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/invitations")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private UserService userService;

    public InvitationController(InvitationService invitationService) {
        this.invitationService = invitationService;
    }

    @GetMapping
    public ResponseEntity<List<Invitation>> getAllInvitations() {
        return ResponseEntity.ok(invitationService.getAllInvitations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invitation> getInvitationById(@PathVariable Long id) {
        Optional<Invitation> inv = invitationService.getInvitationById(id);
        return inv.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Invitation>> getInvitationsByEventId(@PathVariable Long eventId) {
        return ResponseEntity.ok(invitationService.getInvitationsByEventId(eventId));
    }

    @GetMapping("/by-email")
    public ResponseEntity<List<Invitation>> getInvitationsByEmail(@RequestParam String email) {
        return ResponseEntity.ok(invitationService.getInvitationsByEmail(email));
    }

    @PostMapping
    public ResponseEntity<Invitation> createInvitation(@RequestBody Invitation invitation) {
//        System.out.println("here" + invitation.getEvent());
        Event event = eventRepo.findById(invitation.getEventId())
                .orElseThrow(() -> new IllegalArgumentException("Event not found with id: " + invitation.getEventId()));
        User user = userService.getUserById(invitation.getInvitedUserId()).orElse(null);
        if (event == null || event.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
//        if (user == null ) {
//           user =
//        }
        Invitation saved = invitationService.saveInvitation(invitation, event);
        return ResponseEntity.created(URI.create("/api/invitations/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Invitation> updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {

        String status = body.get("status");
        if (status == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Invitation> updated = invitationService.updateInvitationStatus(id, status);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvitation(@PathVariable Long id) {
        invitationService.deleteInvitation(id);
        return ResponseEntity.noContent().build();
    }
}
