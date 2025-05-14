package com.diino.paymentSignature.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "payment_credential")
public class PaymentCredentialEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "app_id")
    private PaymentAppEntity app;

    @Enumerated(EnumType.STRING)
    private PaymentProvider paymentProvider;

    @NotNull
    private String publicKey;

    @NotNull
    private String accessToken;

    @ManyToOne
    @JoinColumn(name = "payment_preference_id")
    private PaymentPreferenceEntity paymentPreference;

    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    protected void onCreated() {
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated = LocalDateTime.now();
    }
}
