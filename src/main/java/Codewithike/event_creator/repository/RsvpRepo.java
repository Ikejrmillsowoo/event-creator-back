package Codewithike.event_creator.repository;

import Codewithike.event_creator.model.RSVP;
import Codewithike.event_creator.model.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RsvpRepo extends JpaRepository<RSVP, Long> {
    Optional<RSVP> findByEvent(Event event);
//    Optional<RSVP> findByEventAndEmail(Long event_id, String email);

}
