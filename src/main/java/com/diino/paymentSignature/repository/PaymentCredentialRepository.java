package com.diino.paymentSignature.repository;

import com.diino.paymentSignature.entity.PaymentCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentCredentialRepository extends JpaRepository<PaymentCredentialEntity, Long>, JpaSpecificationExecutor<PaymentCredentialEntity> {
    // Custom query methods can be defined here if needed
}
