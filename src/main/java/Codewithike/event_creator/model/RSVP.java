package Codewithike.event_creator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RSVP {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long eventId;
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
