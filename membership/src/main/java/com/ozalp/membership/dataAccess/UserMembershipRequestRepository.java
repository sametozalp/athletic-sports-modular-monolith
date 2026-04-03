package com.ozalp.membership.dataAccess;

import com.ozalp.membership.models.entities.UserMembershipRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMembershipRequestRepository extends JpaRepository<UserMembershipRequest, Integer> {
}
