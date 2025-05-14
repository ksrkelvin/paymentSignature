package com.diino.paymentSignature.repository;

import com.diino.paymentSignature.entity.PaymentAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface PaymentAppRepository extends JpaRepository<PaymentAppEntity, Long>, JpaSpecificationExecutor<PaymentAppEntity> {}