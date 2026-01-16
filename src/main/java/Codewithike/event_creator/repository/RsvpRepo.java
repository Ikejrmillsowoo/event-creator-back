package Codewithike.event_creator.repository;

import Codewithike.event_creator.model.RSVP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RsvpRepo extends JpaRepository<RSVP, Long> {
    Optional<RSVP> findByEvent();
    Optional<RSVP> findByEventAndEmail(Long eventId, String email);

}
