package Codewithike.event_creator.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Long eventId;
    @Column
    private Long userId;
    @Column
    private String message;
    @Column
    private String createdAt;
    @Column
    private String updatedAt;

}
