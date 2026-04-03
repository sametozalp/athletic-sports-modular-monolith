package com.ozalp.payment.dataAccess;

import com.ozalp.payment.models.entities.OrganizationPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationPaymentRepository extends JpaRepository<OrganizationPayment, Integer> {
}
