package dev.local.springjwt.dao;

import dev.local.springjwt.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<Users,Long> {
    public Users findByUsername(String username);
}
