package com.diino.paymentSignature.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "payment_app")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PaymentAppEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull private String title;
    @NotNull private String description;
    @NotNull private String urlApp;

    @Enumerated(EnumType.STRING)
    private EnvironmentType env;

    private Boolean active = true;

    @OneToMany(mappedBy = "app", fetch = FetchType.LAZY)
    private List<GatewayCredentialEntity> paymentCredentials;

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
