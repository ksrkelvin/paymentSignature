package com.diino.paymentSignature.dto;

import com.diino.paymentSignature.entity.GatewayCredentialEntity;
import com.diino.paymentSignature.entity.PaymentProvider;
import com.diino.paymentSignature.entity.PreferenceEntity;
import com.diino.paymentSignature.mapper.GatewayCredentialMapper;
import com.diino.paymentSignature.mapper.PreferenceMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class GatewayCredentialDTO {

    private Long id;

    @NotNull(message = "{gatewayCredential.paymentProvider.not-null}")
    @JsonProperty("paymentProvider")
    private PaymentProvider paymentProvider;

    @NotBlank(message = "{gatewayCredential.publicKey.not-blank}")
    @JsonProperty("publicKey")
    private String publicKey;

    @NotBlank(message = "{gatewayCredential.accessToken.not-blank}")
    @JsonProperty("accessToken")
    private String accessToken;

    @JsonProperty("preferences")
    private List<PreferenceDTO> preferences;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("created")
    private LocalDateTime created;

    @JsonProperty("updated")
    private LocalDateTime updated;

    public GatewayCredentialDTO() {}

    public GatewayCredentialDTO(GatewayCredentialEntity entity) {
        this.id = entity.getId();
        this.paymentProvider = entity.getPaymentProvider();
        this.publicKey = entity.getPublicKey();
        this.accessToken = entity.getAccessToken();
        this.active = entity.getActive();
        this.created = entity.getCreated();
        this.updated = entity.getUpdated();

        if (entity.getPreferences() != null) {
            this.preferences = entity.getPreferences()
                    .stream()
                    .map(PreferenceMapper::toDTO)
                    .collect(Collectors.toList());
        }
    }

}
