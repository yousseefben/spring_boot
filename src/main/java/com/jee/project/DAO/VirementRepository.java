package com.jee.project.DAO;

import com.jee.project.Data.Cheque;
import com.jee.project.Data.Virement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirementRepository extends JpaRepository<Virement, Long> {
}
