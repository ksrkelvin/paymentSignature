package com.diino.paymentSignature.mapper;

import com.diino.paymentSignature.dto.GatewayCredentialDTO;
import com.diino.paymentSignature.dto.PaymentAppDTO;
import com.diino.paymentSignature.dto.PreferenceDTO;
import com.diino.paymentSignature.entity.GatewayCredentialEntity;
import com.diino.paymentSignature.entity.PaymentAppEntity;

public class GatewayCredentialMapper {

    public static GatewayCredentialDTO toDTO(GatewayCredentialEntity entity){
        return new GatewayCredentialDTO(entity);
    }

    public static GatewayCredentialEntity toEntity(GatewayCredentialDTO dto){
        GatewayCredentialEntity entity = new GatewayCredentialEntity();
        entity.setId(dto.getId());
        entity.setAccessToken(dto.getAccessToken());
        entity.setPublicKey(dto.getPublicKey());
        entity.setCreated(dto.getCreated());
        entity.setUpdated(dto.getUpdated());
        entity.setPaymentProvider(dto.getPaymentProvider());
        entity.setActive(dto.getActive());
        for (PreferenceDTO preference : dto.getPreferences()) {
            entity.getPreferences().add(PreferenceMapper.toEntity(preference));
        }

        return entity;
    }

}
