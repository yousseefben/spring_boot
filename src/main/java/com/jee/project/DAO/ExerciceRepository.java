package com.jee.project.DAO;

import com.jee.project.Data.Compte;
import com.jee.project.Data.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
}
