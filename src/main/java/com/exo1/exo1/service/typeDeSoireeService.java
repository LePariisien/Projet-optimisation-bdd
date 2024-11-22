package com.exo1.exo1.service;

import com.exo1.exo1.entity.soiree;
import com.exo1.exo1.entity.typeDeSoiree;
import com.exo1.exo1.repository.soireeRepository;
import com.exo1.exo1.repository.typeDeSoireeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class typeDeSoireeService {

    @Autowired
    private typeDeSoireeRepository typeDeSoireeRepository;

    @Autowired
    private soireeRepository soireeRepository;

    public List<typeDeSoiree> getAllTypesDeSoiree() {
        return typeDeSoireeRepository.findAll();
    }

    public typeDeSoiree getTypeDeSoireeById(Long id) {
        return typeDeSoireeRepository.findById(id).orElseThrow(() -> new RuntimeException("Type de soirée non trouvé"));
    }

    public List<soiree> getSoireesByTypeDeSoireeNom(String typeDeSoireeNom) {
    return soireeRepository.findByTypeDeSoireeNom(typeDeSoireeNom);}


    public typeDeSoiree createTypeDeSoiree(typeDeSoiree typeDeSoiree) {
        return typeDeSoireeRepository.save(typeDeSoiree);
    }

    public typeDeSoiree updateTypeDeSoiree(Long id, typeDeSoiree typeDeSoireeDetails) {
        typeDeSoiree typeDeSoiree = typeDeSoireeRepository.findById(id).orElseThrow(() -> new RuntimeException("Type de soirée non trouvé"));
        typeDeSoiree.setNom(typeDeSoireeDetails.getNom());
        return typeDeSoireeRepository.save(typeDeSoiree);
    }

    public void deleteTypeDeSoiree(Long id) {
        typeDeSoireeRepository.deleteById(id);
    }
}
