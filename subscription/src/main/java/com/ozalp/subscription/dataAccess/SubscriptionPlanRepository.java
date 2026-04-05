package com.ozalp.subscription.dataAccess;

import com.ozalp.subscription.models.entities.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Integer> {
}
