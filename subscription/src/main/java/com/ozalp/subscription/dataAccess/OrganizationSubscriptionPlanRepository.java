package com.ozalp.subscription.dataAccess;

import com.ozalp.subscription.models.entities.OrganizationSubscriptionPlan;
import com.ozalp.subscription.models.entities.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationSubscriptionPlanRepository extends JpaRepository<OrganizationSubscriptionPlan, Integer> {
}
