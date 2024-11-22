package com.exo1.exo1.controller;

import com.exo1.exo1.entity.soiree;
import com.exo1.exo1.entity.typeDeSoiree;
import com.exo1.exo1.service.soireeService;
import com.exo1.exo1.service.typeDeSoireeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type-de-soirée")
@Tag(name = "Types de Soirées", description = "Endpoints pour gérer les types de soirées")

public class typeDeSoireeController {

    @Autowired
    private typeDeSoireeService typeDeSoireeService;

    @Autowired
    private soireeService soireeService;

    @Operation(summary = "Obtenir tous les types de soirées")
    @GetMapping
    public List<typeDeSoiree> getAllTypesDeSoiree() {
        return typeDeSoireeService.getAllTypesDeSoiree();
    }

    @Operation(summary = "Obtenir un type de soirée par ID")
    @GetMapping("/{id}")
    public ResponseEntity<typeDeSoiree> getTypeDeSoireeById(@PathVariable Long id) {
        return ResponseEntity.ok(typeDeSoireeService.getTypeDeSoireeById(id));
    }

    @GetMapping("/{nom}/soirees")
    @Operation(summary = "Obtenir les soirées par nom de type de soirée")
    public List<soiree> getSoireesByTypeDeSoireeNom(@PathVariable String nom) {
        return soireeService.getSoireesByTypeDeSoireeNom(nom); 
    }

    @Operation(summary = "Créer un nouveau type de soirée")
    @PostMapping
    public ResponseEntity<typeDeSoiree> createTypeDeSoiree(@RequestBody typeDeSoiree typeDeSoiree) {
        return ResponseEntity.ok(typeDeSoireeService.createTypeDeSoiree(typeDeSoiree));
    }

    @Operation(summary = "Mettre à jour un type de soirée existant")
    @PutMapping("/{id}")
    public ResponseEntity<typeDeSoiree> updateTypeDeSoiree(@PathVariable Long id,
            @RequestBody typeDeSoiree typeDeSoireeDetails) {
        return ResponseEntity.ok(typeDeSoireeService.updateTypeDeSoiree(id, typeDeSoireeDetails));
    }

    @Operation(summary = "Supprimer un type de soirée par ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTypeDeSoiree(@PathVariable Long id) {
        typeDeSoireeService.deleteTypeDeSoiree(id);
        return ResponseEntity.ok("Type de soirée supprimé avec succès !");
    }
}
