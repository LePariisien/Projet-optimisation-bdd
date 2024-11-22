package com.exo1.exo1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adresse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(nullable = false, length = 100)
    private String rue;

    @Column(nullable = false, length = 50)
    private String ville;

    @Column(nullable = false, length = 10)
    private String codePostal;
}
