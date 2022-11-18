package dev.local.springjwt.dao;

import dev.local.springjwt.model.DirecteurEtudes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirecteurEtudesDao extends JpaRepository<DirecteurEtudes, Long> {
}
