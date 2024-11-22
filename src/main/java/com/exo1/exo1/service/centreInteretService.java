package com.exo1.exo1.service;

import com.exo1.exo1.entity.centreInteret;
import com.exo1.exo1.repository.centreInteretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class centreInteretService {

    @Autowired
    private centreInteretRepository centreInteretRepository;

    public List<centreInteret> getAllCentresInteret() {
        return centreInteretRepository.findAll();
    }

    public centreInteret getCentreInteretById(Long id) {
        return centreInteretRepository.findById(id).orElseThrow(() -> new RuntimeException("Centre d'intérêt non trouvé"));
    }

    public centreInteret createCentreInteret(centreInteret centreInteret) {
        return centreInteretRepository.save(centreInteret);
    }

    public centreInteret updateCentreInteret(Long id, centreInteret centreInteretDetails) {
        centreInteret centreInteret = centreInteretRepository.findById(id).orElseThrow(() -> new RuntimeException("Centre d'intérêt non trouvé"));
        centreInteret.setTitre(centreInteretDetails.getTitre());
        centreInteret.setDescription(centreInteretDetails.getDescription());
        return centreInteretRepository.save(centreInteret);
    }

    public void deleteCentreInteret(Long id) {
        centreInteretRepository.deleteById(id);
    }
}
