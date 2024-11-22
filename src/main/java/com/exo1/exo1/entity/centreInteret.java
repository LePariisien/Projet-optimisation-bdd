package com.exo1.exo1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "centre_interet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class centreInteret {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String titre;

    @Column(nullable = false, length = 255)
    private String description;

}
