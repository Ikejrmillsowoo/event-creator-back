package Codewithike.event_creator.model;

import Codewithike.event_creator.model.event.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RSVP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    @JsonIgnore
    private Event event;
    @Column
    private Long userId;
    @Column
    private String response; // e.g., "Yes", "No", "Maybe"
    @Column
    private Boolean plusOnes;   //yes or no only one count
    @Column
    private String createdAt;
    @Column
    private String updatedAt;
}
