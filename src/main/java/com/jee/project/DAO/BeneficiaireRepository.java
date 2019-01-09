package com.jee.project.DAO;

import com.jee.project.Data.Beneficiaire;
import com.jee.project.Data.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, Long> {
}
