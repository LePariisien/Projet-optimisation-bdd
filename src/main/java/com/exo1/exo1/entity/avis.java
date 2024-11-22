package com.exo1.exo1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "avis")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int note;

    @Column(nullable = false, length = 255)
    private String commentaire;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "soiree_id", nullable = false)
    private soiree soiree;
}
