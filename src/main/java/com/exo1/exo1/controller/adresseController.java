package com.exo1.exo1.controller;

import com.exo1.exo1.entity.adresse;
import com.exo1.exo1.service.adresseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresse")
@Tag(name = "Adresses", description = "Endpoints pour gérer les adresses")
public class adresseController {

    @Autowired
    private adresseService adresseService;

    @Operation(summary = "Obtenir toutes les adresses")
    @GetMapping
    public List<adresse> getAllAdresses() {
        return adresseService.getAllAdresses();
    }

    @Operation(summary = "Obtenir une adresse par ID")
    @GetMapping("/{id}")
    public ResponseEntity<adresse> getAdresseById(@PathVariable Long id) {
        return ResponseEntity.ok(adresseService.getAdresseById(id));
    }

    @Operation(summary = "Créer une nouvelle adresse")
    @PostMapping
    public ResponseEntity<adresse> createAdresse(@RequestBody adresse adresse) {
        return ResponseEntity.ok(adresseService.createAdresse(adresse));
    }

    @Operation(summary = "Mettre à jour une adresse existante")
    @PutMapping("/{id}")
    public ResponseEntity<adresse> updateAdresse(@PathVariable Long id, @RequestBody adresse adresseDetails) {
        return ResponseEntity.ok(adresseService.updateAdresse(id, adresseDetails));
    }

    @Operation(summary = "Supprimer une adresse par ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdresse(@PathVariable Long id) {
        adresseService.deleteAdresse(id);
        return ResponseEntity.ok("Adresse supprimée avec succès !");
    }
}
