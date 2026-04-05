package com.ozalp.subscription.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "subscription_plans")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubscriptionPlan extends BaseEntity {

    @Column(nullable = false)
    private String name;

}
