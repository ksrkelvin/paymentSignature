package com.diino.paymentSignature.repository;

import com.diino.paymentSignature.entity.GatewayCredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GatewayCredentialRepository extends JpaRepository<GatewayCredentialEntity, Long>, JpaSpecificationExecutor<GatewayCredentialEntity> {
    List<GatewayCredentialEntity> findByAppId(Long appId);
}
