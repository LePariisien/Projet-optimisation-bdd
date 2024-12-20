package com.exo1.exo1.dto;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class soireeDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String titre;
    private String lieu;
    private String typeDeSoiree;
    private LocalDateTime dateHeure;
    private int placesDisponible;
    private boolean estPayante;
    private Double prix;
    private String description;

}