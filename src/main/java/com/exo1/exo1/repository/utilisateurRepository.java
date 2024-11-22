package com.exo1.exo1.repository;

import com.exo1.exo1.entity.utilisateur;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface utilisateurRepository extends JpaRepository<utilisateur, Long> {
    Optional<utilisateur> findByEmail(String email);
}
