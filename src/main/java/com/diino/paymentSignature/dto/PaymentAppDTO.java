package com.diino.paymentSignature.dto;

import com.diino.paymentSignature.entity.EnvironmentType;
import com.diino.paymentSignature.entity.PaymentAppEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PaymentAppDTO {
    @Id
    private Long id;
    @NotBlank(message = "{paymentApp.title.not-blank}")
    @JsonProperty("title")
    private String title;
    @NotBlank(message = "{paymentApp.description.not-blank}")
    @JsonProperty("description")
    private String description;
    @NotBlank(message = "{paymentApp.url.not-blank}")
    @JsonProperty("urlApp")
    private String urlApp;
    @NotNull(message = "{paymentApp.environment.not-blank}")
    @JsonProperty("environment")
    private EnvironmentType env;
    @JsonProperty("created")
    private LocalDateTime created;
    @JsonProperty("updated")
    private LocalDateTime updated;
    @JsonProperty("gatewayCredentials")
    private List<GatewayCredentialDTO> gatewayCredentials; // Placeholder for the actual type

    public PaymentAppDTO() {}

    public PaymentAppDTO(PaymentAppEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.urlApp = entity.getUrlApp();
        this.env = entity.getEnv();
        this.created = entity.getCreated();
        this.updated = entity.getUpdated();

        if (entity.getPaymentCredentials() != null) {
            this.gatewayCredentials = entity.getPaymentCredentials()
                    .stream()
                    .map(GatewayCredentialDTO::new)
                    .collect(Collectors.toList());
        }
    }

}
