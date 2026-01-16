package Codewithike.event_creator.model.event;

import Codewithike.event_creator.model.Comment;
import Codewithike.event_creator.model.Invitation;
import Codewithike.event_creator.model.RSVP;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @ManyToOne
    private Long hostUserId;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String eventDate;
    @Column
    private String startTime;
    @Column
    private String endTime;
    @Column
    private String location;
    @Column
    private String createdAt;
    @Column
    private String updatedAt;

    @OneToMany
    private java.util.List<Codewithike.event_creator.model.Invitation> invitations;
    @OneToMany
    private java.util.List<Codewithike.event_creator.model.RSVP> rsvps;
    @OneToMany
    private java.util.List<Codewithike.event_creator.model.Comment> comments;

    public Event(Long hostUserId, String title, String description, String eventDate, String startTime, String endTime, String location, String createdAt, String updatedAt, List<Invitation> invitations, List<RSVP> rsvps, List<Comment> comments) {
        this.hostUserId = hostUserId;
        this.title = title;
        this.description = description;
        this.eventDate = eventDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.invitations = invitations;
        this.rsvps = rsvps;
        this.comments = comments;
    }
}
