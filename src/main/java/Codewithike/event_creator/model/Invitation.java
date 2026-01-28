package Codewithike.event_creator.model;

import Codewithike.event_creator.model.event.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "event_id", nullable = false)
    @JsonIgnore // To prevent circular references during serialization
    private Event event;
    @Column
    private String email;
    @Column
    private Long invitedUserId;
    @Column
    private String status; //Pending, Accepted, Declined
    @Column
    private String token;
    @Column
    private String createdAt;
    @Column
    private String updatedAt;


    // Getter to return just the ID in JSON responses
    @JsonProperty("event_id")
    public Long getEventId() {
        return event != null ? event.getId() : null;
    }
    // Custom setter for JSON deserialization
    @JsonProperty("event_id")
    public void setEventId(Long eventId) {
        if (eventId != null) {
            this.event = new Event();
            this.event.setId(eventId);
        }
    }


}
