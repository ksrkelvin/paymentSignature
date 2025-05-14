package com.diino.paymentSignature.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "payment_preference")
public class PaymentPreferenceEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer quantity;
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "app_id")
    private PaymentAppEntity app;

    @OneToMany(mappedBy = "paymentPreference")
    private List<PaymentCredentialEntity> paymentCredentials;  // Relacionamento unidirecional, uma PaymentPreference tem várias PaymentCredential

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
