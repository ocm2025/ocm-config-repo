package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Size(max = 255)
    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @Size(max = 255)
    @NotNull
    @Column(name = "symbol_left", nullable = false)
    private String symbolLeft;

    @Size(max = 255)
    @NotNull
    @Column(name = "symbol_right", nullable = false)
    private String symbolRight;

    @NotNull
    @Column(name = "decimal_place", nullable = false)
    private Character decimalPlace;

    @NotNull
    @Column(name = "value", nullable = false, precision = 25, scale = 4)
    private BigDecimal value;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}