package com.ozalp.subscription.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Subscription extends BaseEntity {

    @Column(nullable = false)
    private Instant startDate;

    @Column(nullable = false)
    private Instant endDate;
}
