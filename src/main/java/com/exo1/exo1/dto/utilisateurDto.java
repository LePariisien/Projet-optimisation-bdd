package com.exo1.exo1.dto;

import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class utilisateurDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String nom;
    private String prenom;
    private int age;
    private String ville;
    private String email;
    private String motDePasse;
    private String preferenceSoiree;
    private adresseDto adresse;
    private Set<Long> centreInteretIds;  
    
}
