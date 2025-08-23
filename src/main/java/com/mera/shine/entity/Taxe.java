package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "taxe")
public class Taxe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "tax_nom", nullable = false)
    private String taxNom;

    @NotNull
    @Column(name = "type", nullable = false)
    private Integer type;

    @NotNull
    @Column(name = "tax_valeur", nullable = false)
    private Double taxValeur;

    @NotNull
    @Column(name = "tax_nature", nullable = false)
    private Integer taxNature;

    @NotNull
    @Column(name = "tax_is_retenue", nullable = false)
    private Integer taxIsRetenue;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "societe", nullable = false)
    private Societe societe;

}