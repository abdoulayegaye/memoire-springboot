package dev.local.springjwt.dao;

import dev.local.springjwt.model.Validateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidateurDao extends JpaRepository<Validateur, Long> {
}
