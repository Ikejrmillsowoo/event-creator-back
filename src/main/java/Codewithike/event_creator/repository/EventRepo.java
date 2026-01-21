package Codewithike.event_creator.repository;

import Codewithike.event_creator.model.User;
import Codewithike.event_creator.model.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
    Optional<User> findByHostId(Long hostId);
    List<Event> upcomingEvents();
}
