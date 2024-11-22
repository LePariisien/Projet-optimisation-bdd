package com.exo1.exo1.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "type_de_soiree")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class typeDeSoiree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nom;

    @OneToMany(mappedBy = "typeDeSoiree")
    private Set<soiree> soirees;
}
