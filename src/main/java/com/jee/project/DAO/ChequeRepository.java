package com.jee.project.DAO;

import com.jee.project.Data.Budget;
import com.jee.project.Data.Cheque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChequeRepository extends JpaRepository<Cheque, Long> {
}
