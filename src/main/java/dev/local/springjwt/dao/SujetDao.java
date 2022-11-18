package dev.local.springjwt.dao;

import dev.local.springjwt.model.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SujetDao extends JpaRepository<Sujet, Long> {
}
