package com.ozalp.membership.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import com.ozalp.membership.models.enums.MembershipStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "memberships")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Membership extends BaseEntity {

    @Column(nullable = false)
    private int organizationId;

    @Column(nullable = false)
    private int userProfileId;

    @Column(nullable = false)
    private Instant joinedAt;

    @Column
    private Instant leftAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MembershipStatus status = MembershipStatus.ACTIVE;

}