package dev.local.springjwt.dao;

import dev.local.springjwt.model.Technologie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologieDao extends JpaRepository<Technologie, Long> {
}
