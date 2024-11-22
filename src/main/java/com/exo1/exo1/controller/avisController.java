package com.exo1.exo1.controller;

import com.exo1.exo1.entity.avis;
import com.exo1.exo1.service.avisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avis")
@Tag(name = "Avis", description = "Endpoints pour gérer les avis")
public class avisController {

    @Autowired
    private avisService avisService;

    @Operation(summary = "Obtenir tous les avis")
    @GetMapping
    public List<avis> getAllAvis() {
        return avisService.getAllAvis();
    }

    @Operation(summary = "Obtenir les avis par ID de soirée")
    @GetMapping("/soiree/{soireeId}")
    public List<avis> getAvisBySoireeId(@PathVariable Long soireeId) {
        return avisService.getAvisBySoireeId(soireeId);
    }

    @Operation(summary = "Obtenir les avis par ID d'utilisateur")
    @GetMapping("/utilisateur/{utilisateurId}")
    public List<avis> getAvisByUtilisateurId(@PathVariable Long utilisateurId) {
        return avisService.getAvisByUtilisateurId(utilisateurId);
    }

    @Operation(summary = "Créer un nouvel avis")
    @PostMapping
    public ResponseEntity<avis> createAvis(@RequestBody avis avis) {
        return ResponseEntity.ok(avisService.createAvis(avis));
    }

    @Operation(summary = "Mettre à jour un avis existant")
    @PutMapping("/{id}")
    public ResponseEntity<avis> updateAvis(@PathVariable Long id, @RequestBody avis avisDetails) {
        return ResponseEntity.ok(avisService.updateAvis(id, avisDetails));
    }

    @Operation(summary = "Supprimer un avis par ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAvis(@PathVariable Long id) {
        avisService.deleteAvis(id);
        return ResponseEntity.ok("Avis supprimé avec succès !");
    }
}
