package com.kinbenaki.ordermicroservice.Repository;

import com.kinbenaki.ordermicroservice.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

