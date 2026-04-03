package com.ozalp.payment.dataAccess;

import com.ozalp.payment.models.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
