package com.jee.project.DAO;

import com.jee.project.Data.CreditOuvert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<CreditOuvert, Long> {
}
