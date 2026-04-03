package com.ozalp.organization.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import com.ozalp.organization.models.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment extends BaseEntity { // FOR LOGS

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @Column
    private BigDecimal amount;

    @Column
    private Instant paymentDate;

    @Column
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

}
