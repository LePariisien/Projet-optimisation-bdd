package com.exo1.exo1.service;

import com.exo1.exo1.entity.avis;
import com.exo1.exo1.repository.avisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class avisService {

    @Autowired
    private avisRepository avisRepository;

    public List<avis> getAllAvis() {
        return avisRepository.findAll();
    }

    public List<avis> getAvisBySoireeId(Long soireeId) {
        return avisRepository.findBySoireeId(soireeId);
    }

    public List<avis> getAvisByUtilisateurId(Long utilisateurId) {
        return avisRepository.findByUtilisateurId(utilisateurId);
    }

    public avis createAvis(avis avis) {
        return avisRepository.save(avis);
    }

    public avis updateAvis(Long id, avis avisDetails) {
        avis avis = avisRepository.findById(id).orElseThrow(() -> new RuntimeException("Avis non trouvé"));
        avis.setNote(avisDetails.getNote());
        avis.setCommentaire(avisDetails.getCommentaire());
        return avisRepository.save(avis);
    }

    public void deleteAvis(Long id) {
        avisRepository.deleteById(id);
    }
}
