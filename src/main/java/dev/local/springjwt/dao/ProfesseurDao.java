package dev.local.springjwt.dao;

import dev.local.springjwt.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurDao extends JpaRepository<Professeur, Long> {
}
