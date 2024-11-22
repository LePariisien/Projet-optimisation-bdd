package com.exo1.exo1.service;

import com.exo1.exo1.entity.adresse;
import com.exo1.exo1.repository.adresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adresseService {

    @Autowired
    private adresseRepository adresseRepository;

    public List<adresse> getAllAdresses() {
        return adresseRepository.findAll();
    }

    public adresse getAdresseById(Long id) {
        return adresseRepository.findById(id).orElseThrow(() -> new RuntimeException("Adresse non trouvée"));
    }

    public adresse createAdresse(adresse adresse) {
        return adresseRepository.save(adresse);
    }

    public adresse updateAdresse(Long id, adresse adresseDetails) {
        adresse adresse = adresseRepository.findById(id).orElseThrow(() -> new RuntimeException("Adresse non trouvée"));
        adresse.setNumero(adresseDetails.getNumero());
        adresse.setRue(adresseDetails.getRue());
        adresse.setVille(adresseDetails.getVille());
        adresse.setCodePostal(adresseDetails.getCodePostal());
        return adresseRepository.save(adresse);
    }

    public void deleteAdresse(Long id) {
        adresseRepository.deleteById(id);
    }
}
