package com.ozalp.subscription.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import com.ozalp.subscription.models.enums.BillingCycle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "subscription_plans")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class SubscriptionPlan extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean isPopular = false;

    @Column
    private List<String> features;

    @Column(nullable = false)
    private BillingCycle billingCycle;

}
