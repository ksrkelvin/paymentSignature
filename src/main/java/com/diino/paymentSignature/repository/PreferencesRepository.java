package com.diino.paymentSignature.repository;

import com.diino.paymentSignature.entity.PreferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PreferencesRepository extends JpaRepository<PreferenceEntity, Long>, JpaSpecificationExecutor<PreferenceEntity> {
    List<PreferenceEntity> findByAppIdAndCredentialId(Long appId, Long credentialId);
}
