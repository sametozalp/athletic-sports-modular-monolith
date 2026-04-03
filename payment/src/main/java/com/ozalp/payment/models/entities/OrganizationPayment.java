package com.ozalp.payment.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organization_payments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrganizationPayment extends Payment { // FOR LOGS

    @Column(nullable = false)
    private int organizationId;

}
