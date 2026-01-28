//java
package Codewithike.event_creator.service;

import Codewithike.event_creator.model.Invitation;
import Codewithike.event_creator.model.event.Event;
import Codewithike.event_creator.repository.EventRepo;
import Codewithike.event_creator.repository.InvitationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvitationService {

     @Autowired
     private InvitationRepo invitationRepo;

     @Autowired
     private EventRepo eventRepo;

//    public InvitationService(InvitationRepo invitationRepo) {
//        this.invitationRepo = invitationRepo;
//    }

    public Invitation saveInvitation(Invitation invitation, Event event) {
        Invitation invite = new Invitation();
        invite.setEmail(invitation.getEmail());
        invite.setInvitedUserId(invitation.getInvitedUserId());
        invite.setStatus(invitation.getStatus());
        invite.setToken(invitation.getToken());

        invite.setEvent(event);
        return invitationRepo.save(invite);
    }

    public Optional<Invitation> getInvitationById(Long id) {
        return invitationRepo.findById(id);
    }

    public List<Invitation> getAllInvitations() {
        return invitationRepo.findAll();
    }

    // Safe fallback: filter in memory in case repository doesn't declare a findByEventId method
    public List<Invitation> getInvitationsByEventId(Long eventId) {
        return invitationRepo.findAll()
                .stream()
                .filter(inv -> inv.getEvent().getId() != null && inv.getEvent().getId().equals(eventId))
                .collect(Collectors.toList());
    }

    public List<Invitation> getInvitationsByEmail(String email) {
        return invitationRepo.findAll()
                .stream()
                .filter(inv -> inv.getEmail() != null && inv.getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }

    public Optional<Invitation> updateInvitationStatus(Long id, String status) {
        return invitationRepo.findById(id).map(inv -> {
            inv.setStatus(status);
            return invitationRepo.save(inv);
        });
    }

    public void deleteInvitation(Long id) {
        invitationRepo.deleteById(id);
    }
}
