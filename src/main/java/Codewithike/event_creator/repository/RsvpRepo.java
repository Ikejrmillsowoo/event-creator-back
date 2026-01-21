package Codewithike.event_creator.repository;

import Codewithike.event_creator.model.RSVP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RsvpRepo extends JpaRepository<RSVP, Long> {
    Optional<RSVP> findByEvent();
    Optional<RSVP> findByEventAndEmail(Long eventId, String email);

}
