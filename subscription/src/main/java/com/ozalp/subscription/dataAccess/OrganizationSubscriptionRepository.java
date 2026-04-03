package com.ozalp.subscription.dataAccess;

import com.ozalp.subscription.models.entities.OrganizationSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationSubscriptionRepository extends JpaRepository<OrganizationSubscription, Integer> {
}
