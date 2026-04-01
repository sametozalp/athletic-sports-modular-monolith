package com.ozalp.auth.dataAccess;

import com.ozalp.auth.models.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Query(value = "select * from user_roles u where u.user_id = :userId", nativeQuery = true)
    List<UserRole> getUserRoles(int userId);
}
