package com.diino.paymentSignature.dto;

import com.diino.paymentSignature.entity.PreferenceEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PreferenceDTO {

    private Long id;



    @NotBlank(message = "{paymentPreference.title.not-blank}")
    @JsonProperty("title")
    private String title;

    @NotNull(message = "{paymentPreference.quantity.not-null}")
    @JsonProperty("quantity")
    private Integer quantity;

    @NotNull(message = "{paymentPreference.unitPrice.not-null}")
    @JsonProperty("unitPrice")
    private BigDecimal unitPrice;

    @JsonProperty("created")
    private LocalDateTime created;

    @JsonProperty("updated")
    private LocalDateTime updated;

    public PreferenceDTO() {}

    public PreferenceDTO(PreferenceEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.quantity = entity.getQuantity();
        this.unitPrice = entity.getUnitPrice();
        this.created = entity.getCreated();
        this.updated = entity.getUpdated();
    }
}
