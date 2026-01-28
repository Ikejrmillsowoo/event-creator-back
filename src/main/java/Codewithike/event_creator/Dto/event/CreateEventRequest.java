package Codewithike.event_creator.Dto.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEventRequest {

    @NotNull
    private Long hostUserId;

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private String eventDate; // format: YYYY-MM-DD

    @NotBlank
    private String startTime; // format: HH:mm

    @NotBlank
    private String endTime; // format: HH:mm

    @NotBlank
    private String location;
}
