package com.jee.project.DAO;

import com.jee.project.Data.Role;
import com.jee.project.Data.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);

}
