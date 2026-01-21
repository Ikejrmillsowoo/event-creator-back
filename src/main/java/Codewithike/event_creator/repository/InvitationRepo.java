package Codewithike.event_creator.repository;

import Codewithike.event_creator.model.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvitationRepo extends JpaRepository<Invitation, Long> {
    Optional<Invitation> findByEventId(Long eventId);
    Optional<Invitation> findByEventAndEmail(Long eventId, String email);
}
