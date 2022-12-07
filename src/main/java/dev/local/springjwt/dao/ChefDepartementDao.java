package dev.local.springjwt.dao;

import dev.local.springjwt.model.ChefDepartement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefDepartementDao extends JpaRepository<ChefDepartement, Long> {

}
