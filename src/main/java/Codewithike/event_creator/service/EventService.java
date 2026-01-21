package Codewithike.event_creator.service;

import Codewithike.event_creator.model.User;
import Codewithike.event_creator.model.event.Event;
import Codewithike.event_creator.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventRepo eventRepo;

    public Event createEvent(User user) {
        eventRepo.save();
        // Implementation for creating an event
        return new Event();
    }
}
