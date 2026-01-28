package Codewithike.event_creator.service;

import Codewithike.event_creator.model.User;
import Codewithike.event_creator.model.event.Event;
import Codewithike.event_creator.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    EventRepo eventRepo;

    public Event createEvent(Event event) {
        eventRepo.save(event);
        return new Event();
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepo.getReferenceById(id);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = getEventById(id);
        event.setTitle(eventDetails.getTitle());
        event.setDescription(eventDetails.getDescription());
        event.setEventDate(eventDetails.getEventDate());
        event.setLocation(eventDetails.getLocation());
        return eventRepo.save(event);
    }

    public Optional<User> getEventsByHost(User host) {
        Long hostUserId = host.getId();
        return eventRepo.findByHostUserId(hostUserId);
    }


    public void cancelEvent(Long id) {
        Event event = getEventById(id);
        eventRepo.delete(event);
    }
}
