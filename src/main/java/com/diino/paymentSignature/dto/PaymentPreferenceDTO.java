package com.diino.paymentSignature.dto;

import com.diino.paymentSignature.entity.PaymentAppEntity;
import com.diino.paymentSignature.entity.PaymentCredentialEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PaymentPreferenceDTO {
    @Id
    private Long ID;
    @NotBlank(message = "{paymentPreference.title.not-blank}")
    @JsonProperty("title")
    private String title;
    @NotBlank (message = "{paymentPreference.quantity.not-blank}")
    @JsonProperty("quantity")
    private Integer quantity;
    @NotBlank (message = "{paymentPreference.unitPrice.not-blank}")
    @JsonProperty("unitPrice")
    private BigDecimal unitPrice;
    @NotNull(message = "{paymentPreference.paymentAppEntity.not-blank}")
    @JsonProperty("paymentAppEntity")
    private PaymentAppDTO App;
    @NotNull (message = "{paymentPreference.paymentCredentialEntity.not-blank}")
    @JsonProperty("paymentCredentialEntity")
    private List<PaymentCredentialDTO> PaymentCredentials;
    @JsonProperty("created")
    private LocalDateTime created;
    @JsonProperty("updated")
    private LocalDateTime updated;
}
