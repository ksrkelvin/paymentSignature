package com.diino.paymentSignature.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "payment_gateway_credential")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class GatewayCredentialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "app_id")
    private PaymentAppEntity app;

    @Enumerated(EnumType.STRING)
    private PaymentProvider paymentProvider;

    @NotNull private String publicKey;
    @NotNull private String accessToken;

    private Boolean active = true;

    @OneToMany(mappedBy = "credential", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PreferenceEntity> preferences;

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
