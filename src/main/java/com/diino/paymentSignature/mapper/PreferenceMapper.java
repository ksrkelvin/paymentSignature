package com.diino.paymentSignature.mapper;

import com.diino.paymentSignature.dto.PreferenceDTO;
import com.diino.paymentSignature.entity.PreferenceEntity;

public class PreferenceMapper {
    public static PreferenceDTO toDTO(PreferenceEntity entity) {
        return new PreferenceDTO(entity);
    }

    public static PreferenceEntity toEntity(PreferenceDTO dto) {
        PreferenceEntity entity = new PreferenceEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setQuantity(dto.getQuantity());
        entity.setUnitPrice(dto.getUnitPrice());
        entity.setCreated(dto.getCreated());
        entity.setUpdated(dto.getUpdated());
        return entity;
    }
}
