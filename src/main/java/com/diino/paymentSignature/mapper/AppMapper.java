package com.diino.paymentSignature.mapper;

import com.diino.paymentSignature.dto.GatewayCredentialDTO;
import com.diino.paymentSignature.dto.PaymentAppDTO;
import com.diino.paymentSignature.entity.GatewayCredentialEntity;
import com.diino.paymentSignature.entity.PaymentAppEntity;

import java.util.List;

public class AppMapper {

    public static PaymentAppDTO toDTO(PaymentAppEntity entity){
        return new PaymentAppDTO(entity);
    }

    public static PaymentAppEntity toEntity(PaymentAppDTO dto){
        PaymentAppEntity entity = new PaymentAppEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setUrlApp(dto.getUrlApp());
        entity.setEnv(dto.getEnv());
        entity.setCreated(dto.getCreated());
        entity.setUpdated(dto.getUpdated());
        for (GatewayCredentialDTO gatewayCredential : dto.getGatewayCredentials()) {
            entity.getPaymentCredentials().add(GatewayCredentialMapper.toEntity(gatewayCredential));
        }

        return entity;
    }
}
