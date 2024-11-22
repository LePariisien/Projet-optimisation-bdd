package com.exo1.exo1.service;

import com.exo1.exo1.entity.soiree;
import com.exo1.exo1.repository.adresseRepository;
import com.exo1.exo1.repository.soireeRepository;
import com.exo1.exo1.repository.utilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class soireeService {

    @Autowired
    private soireeRepository soireeRepository;

    @Autowired
    private utilisateurRepository utilisateurRepository;

    @Autowired
    private adresseRepository adresseRepository;

    public List<soiree> getAllSoirees() {
        return soireeRepository.findAll();
    }

    public Optional<soiree> getSoireeById(Long id) {
        return soireeRepository.findById(id);
    }

    public soiree createSoiree(soiree soiree) {
        if (soiree.getOrganisateur() == null || soiree.getOrganisateur().getId() == null) {
            throw new RuntimeException("L'organisateur doit être fourni avec un ID valide.");
        }
        soiree.setOrganisateur(
            utilisateurRepository.findById(soiree.getOrganisateur().getId())
                .orElseThrow(() -> new RuntimeException("Organisateur non trouvé avec l'ID : " + soiree.getOrganisateur().getId()))
        );
    
        if (soiree.getAdresse() == null || soiree.getAdresse().getId() == null) {
            throw new RuntimeException("L'adresse doit être fournie avec un ID valide.");
        }
        soiree.setAdresse(
            adresseRepository.findById(soiree.getAdresse().getId())
                .orElseThrow(() -> new RuntimeException("Adresse non trouvée avec l'ID : " + soiree.getAdresse().getId()))
        );
    
        return soireeRepository.save(soiree);
    }
    
                                    
    public soiree updateSoiree(Long id, soiree soireeDetails) {
        soiree soiree = soireeRepository.findById(id).orElseThrow(() -> new RuntimeException("Soirée non trouvée"));
        soiree.setTitre(soireeDetails.getTitre());
        soiree.setLieu(soireeDetails.getLieu());
        soiree.setDateHeure(soireeDetails.getDateHeure());
        soiree.setPlacesDisponible(soireeDetails.getPlacesDisponible());
        soiree.setEstPayante(soireeDetails.isEstPayante());
        soiree.setPrix(soireeDetails.getPrix());
        soiree.setDescription(soireeDetails.getDescription());
        return soireeRepository.save(soiree);
    }

    public void deleteSoiree(Long id) {
        soireeRepository.deleteById(id);
    }

    public List<soiree> getSoireesByTypeDeSoireeNom(String typeDeSoireeNom) {
        return soireeRepository.findByTypeDeSoireeNom(typeDeSoireeNom);
    }

    public Map<String, List<soiree>> partitionSoireesByDate() {
        List<soiree> allSoirees = soireeRepository.findAll();

        return allSoirees.stream()
                .collect(Collectors.partitioningBy(
                        soiree -> soiree.getDateHeure().isAfter(LocalDateTime.now())
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey() ? "A venir" : "Passées",
                        Map.Entry::getValue
                ));
    }
}
