package com.exo1.exo1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class avisDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private int note;
    private String commentaire;
    private Long utilisateurId;  
    private Long soireeId;       
}
