package com.ozalp.subscription.dataAccess;

import com.ozalp.subscription.models.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
