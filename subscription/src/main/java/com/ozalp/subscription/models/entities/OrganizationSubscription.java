package com.ozalp.subscription.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organization_subscriptions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrganizationSubscription extends Subscription {

    @Column(nullable = false)
    private int organizationId;
}
