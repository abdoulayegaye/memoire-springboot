package dev.local.springjwt.dao;

import dev.local.springjwt.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
    Etudiant findByMatriculeET(String matricule);
}
