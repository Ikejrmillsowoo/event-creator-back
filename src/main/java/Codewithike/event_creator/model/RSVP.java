package Codewithike.event_creator.model;

public class RSVP {
    private Long id;
    private Long eventId;
    private Long userId;
    private String response; // e.g., "Yes", "No", "Maybe"
    private Boolean plusOnes;   //yes or no only one count
    private String updatedAt;
}
