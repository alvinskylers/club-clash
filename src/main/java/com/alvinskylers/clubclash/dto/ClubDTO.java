package com.alvinskylers.clubclash.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ClubDTO {
    private Long id;
    private String title;
    private String description;
    private String photoURL;
    private LocalDateTime createdOn;
    private LocalDateTime editedOn;
}
