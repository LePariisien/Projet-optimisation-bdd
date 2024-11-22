package com.exo1.exo1.controller;

import com.exo1.exo1.entity.soiree;
import com.exo1.exo1.service.soireeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/soirée")
@Tag(name = "Soirées", description = "Endpoints pour gérer les soirées")
public class soireeController {

    @Autowired
    private soireeService soireeService;

    @GetMapping
    @Operation(summary = "Obtenir toutes les soirées")
    public List<soiree> getAllSoirees() {
        return soireeService.getAllSoirees();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir une soirée par ID")
    public ResponseEntity<soiree> getSoireeById(@PathVariable Long id) {
        return soireeService.getSoireeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Créer une nouvelle soirée")
    public ResponseEntity<soiree> createSoiree(@RequestBody soiree soiree) {
        if (soiree.getOrganisateur() == null || soiree.getOrganisateur().getId() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(soireeService.createSoiree(soiree));
    }
    

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une soirée existante")
    public ResponseEntity<soiree> updateSoiree(@PathVariable Long id, @RequestBody soiree soireeDetails) {
        return soireeService.getSoireeById(id)
                .map(existingSoiree -> ResponseEntity.ok(soireeService.updateSoiree(id, soireeDetails)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une soirée")
    public ResponseEntity<String> deleteSoiree(@PathVariable Long id) {
        return soireeService.getSoireeById(id)
                .map(existingSoiree -> {
                    soireeService.deleteSoiree(id);
                    return ResponseEntity.ok("Soirée supprimée avec succès !");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/partition")
    public ResponseEntity<Map<String, List<soiree>>> getPartitionedSoirees() {
        return ResponseEntity.ok(soireeService.partitionSoireesByDate());
    }
}
