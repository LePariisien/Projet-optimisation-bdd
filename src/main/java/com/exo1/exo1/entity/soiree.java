package com.exo1.exo1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "soiree")
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class soiree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String titre;

    @Column(nullable = false, length = 100)
    private String lieu;

    @Column(nullable = false)
    private LocalDateTime dateHeure;

    @Column(nullable = false)
    private int placesDisponible;

    @Column(nullable = false)
    private boolean estPayante;

    @Column(nullable = false)
    private Double prix;

    @Column(nullable = false, length = 500)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "organisateur_id", nullable = false)
    private utilisateur organisateur;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id", referencedColumnName = "id")
    private adresse adresse;

    @ManyToOne
    @JoinColumn(name = "type_de_soiree_id", nullable = false)
    private typeDeSoiree typeDeSoiree;

}
