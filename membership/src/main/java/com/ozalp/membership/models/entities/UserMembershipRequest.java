package com.ozalp.membership.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import com.ozalp.membership.models.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_membership_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMembershipRequest extends BaseEntity {

    @Column(nullable = false)
    private int userProfileId;

    @Column(nullable = false)
    private int organizationId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RequestStatus status = RequestStatus.PENDING;
    ;

}