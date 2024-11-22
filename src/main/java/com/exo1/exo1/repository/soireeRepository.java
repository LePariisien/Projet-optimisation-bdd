package com.exo1.exo1.repository;

import com.exo1.exo1.entity.soiree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface soireeRepository extends JpaRepository<soiree, Long> {
    List<soiree> findByLieu(String lieu);
    @Query("SELECT s FROM soiree s WHERE s.typeDeSoiree.nom = :typeDeSoireeNom")
    List<soiree> findByTypeDeSoireeNom(@Param("typeDeSoireeNom") String typeDeSoireeNom);

}
