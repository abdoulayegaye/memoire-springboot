package dev.local.springjwt.dao;

import dev.local.springjwt.model.Etudiant;
import dev.local.springjwt.model.Sujet;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
    Etudiant findByMatriculeET(String matricule);
    public List<Etudiant> findBySujetsIn(List<Sujet> sujets);
}
