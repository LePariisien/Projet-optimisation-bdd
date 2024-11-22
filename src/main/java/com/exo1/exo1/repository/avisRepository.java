package com.exo1.exo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exo1.exo1.entity.avis;

import java.util.List;

public interface avisRepository extends JpaRepository<avis, Long> {
    List<avis> findBySoireeId(Long soireeId);
    List<avis> findByUtilisateurId(Long utilisateurId);
}
