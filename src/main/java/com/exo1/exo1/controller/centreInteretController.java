package com.exo1.exo1.controller;

import com.exo1.exo1.entity.centreInteret;
import com.exo1.exo1.service.centreInteretService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centre-interet")
@Tag(name = "Centres d'intérêt", description = "Endpoints pour gérer les centres d'intérêt")

public class centreInteretController {

    @Autowired
    private centreInteretService centreInteretService;

    @Operation(summary = "Obtenir tous les centres d'intérêt")
    @GetMapping
    public List<centreInteret> getAllCentresInteret() {
        return centreInteretService.getAllCentresInteret();
    }

    @Operation(summary = "Obtenir un centre d'intérêt par ID")
    @GetMapping("/{id}")
    public ResponseEntity<centreInteret> getCentreInteretById(@PathVariable Long id) {
        return ResponseEntity.ok(centreInteretService.getCentreInteretById(id));
    }

    @Operation(summary = "Créer un nouveau centre d'intérêt")
    @PostMapping
    public ResponseEntity<centreInteret> createCentreInteret(@RequestBody centreInteret centreInteret) {
        return ResponseEntity.ok(centreInteretService.createCentreInteret(centreInteret));
    }

    @Operation(summary = "Mettre à jour un centre d'intérêt existant")
    @PutMapping("/{id}")
    public ResponseEntity<centreInteret> updateCentreInteret(@PathVariable Long id, @RequestBody centreInteret centreInteretDetails) {
        return ResponseEntity.ok(centreInteretService.updateCentreInteret(id, centreInteretDetails));
    }

    @Operation(summary = "Supprimer un centre d'intérêt par ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCentreInteret(@PathVariable Long id) {
        centreInteretService.deleteCentreInteret(id);
        return ResponseEntity.ok("Centre d'intérêt supprimé avec succès !");
    }
}
