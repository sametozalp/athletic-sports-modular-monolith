package com.ozalp.subscription.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "organization_subscriptions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrganizationSubscription extends BaseEntity {

    @Column(nullable = false)
    private int organizationId;

    @Column(nullable = false)
    private Instant startDate;

    @Column(nullable = false)
    private Instant endDate;
}
