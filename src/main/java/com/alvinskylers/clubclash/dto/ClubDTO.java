package com.alvinskylers.clubclash.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ClubDTO {
    private Long id;
    @NotEmpty(message = "club title should not be empty")
    private String title;
    @NotEmpty(message = "club description should not be empty")
    private String description;
    @NotEmpty(message = "club photoURI should not be empty")
    private String photoURL;
    private LocalDateTime createdOn;
    private LocalDateTime editedOn;
}
