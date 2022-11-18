package dev.local.springjwt.dao;

import dev.local.springjwt.model.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineDao extends JpaRepository<Domaine, Long> {
}
