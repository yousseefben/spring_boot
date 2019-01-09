package com.jee.project.DAO;

import com.jee.project.Data.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
}
