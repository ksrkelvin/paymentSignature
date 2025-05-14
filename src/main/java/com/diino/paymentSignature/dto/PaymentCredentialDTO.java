package com.diino.paymentSignature.dto;

import com.diino.paymentSignature.entity.PaymentAppEntity;
import com.diino.paymentSignature.entity.PaymentCredentialEntity;
import com.diino.paymentSignature.entity.PaymentPreferenceEntity;
import com.diino.paymentSignature.entity.PaymentProvider;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentCredentialDTO {
    @Id
    private Long ID;
    @JsonProperty("paymentAppEntity")
    private PaymentAppEntity App;
    @NotNull(message = "{paymentCredential.paymentProvider.not-blank}")
    @JsonProperty("paymentProvider")
    private PaymentProvider PaymentProvider;

    @NotBlank(message = "{paymentCredential.publicKey.not-blank}")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String publicKey;
    @NotBlank(message = "{paymentCredential.accessToken.not-blank}")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String accessToken;

    @JsonProperty("created")
    private LocalDateTime created;
    @JsonProperty("updated")
    private LocalDateTime updated;

    public PaymentCredentialDTO(){}

    public PaymentCredentialDTO(PaymentCredentialEntity entity) {
        this.ID = entity.getId();
        this.App = entity.getApp();
        this.PaymentProvider = entity.getPaymentProvider();
        this.created = entity.getCreated();
        this.updated = entity.getUpdated();

    }
}
