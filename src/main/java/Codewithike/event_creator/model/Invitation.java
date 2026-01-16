package Codewithike.event_creator.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long eventId;
    @Column
    private String email;
    @Column
    private Long invitedUserId;
    @Column
    private String status;
    @Column
    private String token;
    @Column
    private String createdAt;
    @Column
    private String updatedAt;
}
