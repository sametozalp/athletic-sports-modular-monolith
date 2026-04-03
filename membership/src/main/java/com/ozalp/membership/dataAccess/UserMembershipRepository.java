package com.ozalp.membership.dataAccess;

import com.ozalp.membership.models.entities.UserMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMembershipRepository extends JpaRepository<UserMembership, Integer> {
}
