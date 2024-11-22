package com.exo1.exo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exo1.exo1.entity.soiree;
import com.exo1.exo1.entity.typeDeSoiree;

public interface typeDeSoireeRepository extends JpaRepository<typeDeSoiree, Long> {
    @Query("SELECT s FROM soiree s WHERE s.typeDeSoiree.nom = :typeDeSoireeNom")
    List<soiree> findByTypeDeSoireeNom(@Param("typeDeSoireeNom") String typeDeSoireeNom);
}
