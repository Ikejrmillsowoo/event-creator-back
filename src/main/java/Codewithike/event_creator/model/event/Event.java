package Codewithike.event_creator.model.event;

import Codewithike.event_creator.model.Comment;
import Codewithike.event_creator.model.Invitation;
import Codewithike.event_creator.model.RSVP;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "host_user_id")
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

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invitation> invitations = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RSVP> rsvps = new ArrayList<>();

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

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
        this.invitations = invitations != null ? invitations : new ArrayList<>();
        this.rsvps = rsvps != null ? rsvps : new ArrayList<>();
        this.comments = comments != null ? comments : new ArrayList<>();
    }
}
