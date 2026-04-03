package com.ozalp.payment.models.entities;

import com.ozalp.core.models.entites.BaseEntity;
import com.ozalp.payment.models.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "organization_payments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrganizationPayment extends BaseEntity { // FOR LOGS

    @Column(nullable = false)
    private int organizationId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private Instant paymentDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

}
