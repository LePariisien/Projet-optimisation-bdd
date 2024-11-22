package com.exo1.exo1.service;

import com.exo1.exo1.entity.centreInteret;
import com.exo1.exo1.entity.utilisateur;
import com.exo1.exo1.repository.adresseRepository;
import com.exo1.exo1.repository.centreInteretRepository;
import com.exo1.exo1.repository.utilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class utilisateurService {

    @Autowired
    private utilisateurRepository utilisateurRepository;

    @Autowired
    private centreInteretRepository centreInteretRepository;

    @Autowired
    private adresseRepository adresseRepository;

    public List<utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Optional<utilisateur> getUtilisateurByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }    

    public utilisateur createUtilisateur(utilisateur utilisateur) {
        // Gestion de l'adresse
        if (utilisateur.getAdresse() != null) {
            // Sauvegarde l'adresse si son ID est 0
            if (utilisateur.getAdresse().getId() == 0) {
                utilisateur.setAdresse(adresseRepository.save(utilisateur.getAdresse()));
            } else {
                utilisateur.setAdresse(
                    adresseRepository.findById(utilisateur.getAdresse().getId())
                        .orElseThrow(() -> new RuntimeException("Adresse non trouvée avec l'ID : " + utilisateur.getAdresse().getId()))
                );
            }
        }
    
        if (utilisateur.getCentresInteret() != null) {
            Set<centreInteret> processedCentresInteret = new HashSet<>();
            for (centreInteret ci : utilisateur.getCentresInteret()) {
                if (ci.getId() == 0) {
                    processedCentresInteret.add(centreInteretRepository.save(ci));
                } else {
                    processedCentresInteret.add(
                        centreInteretRepository.findById(ci.getId())
                            .orElseThrow(() -> new RuntimeException("Centre d'intérêt non trouvé avec l'ID : " + ci.getId()))
                    );
                }
            }
            utilisateur.setCentresInteret(processedCentresInteret);
        }
    
        return utilisateurRepository.save(utilisateur);
    }    


// public void inscrireUtilisateur(utilisateur utilisateur) {
    //     utilisateur.setMotDePasse(PasswordEncoder.encode(utilisateur.getMotDePasse()));
    //     utilisateurRepository.save(utilisateur);
    // }

    public utilisateur updateUtilisateur(Long id, utilisateur utilisateurDetails) {
        utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        utilisateur.setNom(utilisateurDetails.getNom());
        utilisateur.setPrenom(utilisateurDetails.getPrenom());
        utilisateur.setAge(utilisateurDetails.getAge());
        utilisateur.setEmail(utilisateurDetails.getEmail());
        utilisateur.setMotDePasse(utilisateurDetails.getMotDePasse());
        utilisateur.setPreferenceSoiree(utilisateurDetails.getPreferenceSoiree());
        return utilisateurRepository.save(utilisateur);
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
