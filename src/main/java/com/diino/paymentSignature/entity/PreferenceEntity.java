package com.diino.paymentSignature.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment_preference")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PreferenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String title;
    private Integer quantity;
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "app_id")
    private PaymentAppEntity app;

    @ManyToOne
    @JoinColumn(name = "credential_id")
    private GatewayCredentialEntity credential;


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
