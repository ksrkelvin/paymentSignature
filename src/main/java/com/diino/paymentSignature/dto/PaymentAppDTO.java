package com.diino.paymentSignature.dto;

import com.diino.paymentSignature.entity.EnvironmentType;
import com.diino.paymentSignature.entity.PaymentAppEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

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

    public PaymentAppDTO() {}

    public PaymentAppDTO(PaymentAppEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.urlApp = entity.getUrlApp();
        this.env = entity.getEnv();
        this.created = entity.getCreated();
        this.updated = entity.getUpdated();
    }
}
