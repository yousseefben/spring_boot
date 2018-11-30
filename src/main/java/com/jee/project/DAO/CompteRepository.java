package com.jee.project.DAO;

import com.jee.project.Data.Compte;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompteRepository extends JpaRepository<Compte, Long> {
}
