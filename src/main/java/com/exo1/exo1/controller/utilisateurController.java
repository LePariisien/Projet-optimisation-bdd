package com.exo1.exo1.controller;

import com.exo1.exo1.entity.utilisateur;
import com.exo1.exo1.service.utilisateurService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/utilisateurs")
@Tag(name = "utilisateurs", description = "Endpoints pour gérer les utilisateurs")
public class utilisateurController {

    @Autowired
    private utilisateurService utilisateurService;

    @GetMapping
    @Operation(summary = "Obtenir tous les utilisateurs")
    public List<utilisateur> getAllutilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un utilisateur par ID")
    public ResponseEntity<utilisateur> getutilisateurById(@PathVariable Long id) {
        utilisateur utilisateur = utilisateurService.getUtilisateurById(id)
                .orElse(null); // Renvoie null si l'utilisateur n'existe pas
        if (utilisateur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(utilisateur);
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Obtenir un utilisateur par email")
    public ResponseEntity<utilisateur> getUtilisateurByEmail(@PathVariable String email) {
        utilisateur utilisateur = utilisateurService.getUtilisateurByEmail(email)
                .orElse(null);
        if (utilisateur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(utilisateur);
    }

    @PostMapping("/inscription")
    @Operation(summary = "Créer un nouvel utilisateur")
    public utilisateur createutilisateur(@RequestBody utilisateur utilisateur) {
        return utilisateurService.createUtilisateur(utilisateur);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un utilisateur existant")
    public ResponseEntity<utilisateur> updateutilisateur(@PathVariable Long id,
            @RequestBody utilisateur utilisateurDetails) {
        return ResponseEntity.ok(utilisateurService.updateUtilisateur(id, utilisateurDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un utilisateur")
    public ResponseEntity<Void> deleteutilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build();
    }
}
