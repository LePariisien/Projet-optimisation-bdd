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
public class adresseDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;
    private String numero;
    private String rue;
    private String ville;
    private String codePostal;
}
