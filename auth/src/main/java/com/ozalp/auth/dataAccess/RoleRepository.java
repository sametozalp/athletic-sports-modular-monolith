package com.ozalp.auth.dataAccess;

import com.ozalp.auth.models.entities.Role;
import com.ozalp.auth.models.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(RoleEnum roleEnum);
}
