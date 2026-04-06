package com.ozalp.subscription.models.entities;

import com.ozalp.subscription.models.enums.BillingCycle;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "organization_subscription_plans")
@NoArgsConstructor
@Getter
@Setter
public class OrganizationSubscriptionPlan extends SubscriptionPlan {

    public OrganizationSubscriptionPlan(String name, String description, BigDecimal price, boolean isPopular, List<String> features, BillingCycle billingCycle) {
        super(name, description, price, isPopular, features, billingCycle);
    }
}
