package Codewithike.event_creator.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class RSVP {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long eventId;
    private Long userId;
    private String response; // e.g., "Yes", "No", "Maybe"
    private Boolean plusOnes;   //yes or no only one count
    private String updatedAt;
}
