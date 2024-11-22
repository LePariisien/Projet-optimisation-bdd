package com.exo1.exo1.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utilisateur")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilisateur_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;
    private int age;

    @Column(nullable = false, length = 50)
    private String ville;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String motDePasse;

    @Column(nullable = false, length = 150)
    private String preferenceSoiree;

    

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "adresse_id", referencedColumnName = "id")
    private adresse adresse;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "utilisateur_centre_interet",
        joinColumns = @JoinColumn(name = "utilisateur_id"),
        inverseJoinColumns = @JoinColumn(name = "centre_interet_id")
    )
    private Set<centreInteret> centresInteret;
    
}
