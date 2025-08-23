package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "items_condition_paiement")
public class ItemsConditionPaiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "icp_id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "icp_type_echeance", nullable = false)
    private Integer icpTypeEcheance;

    @NotNull
    @Column(name = "cpi_valeur", nullable = false)
    private Integer cpiValeur;

    @NotNull
    @Column(name = "icp_delais", nullable = false)
    private Integer icpDelais;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "condition_paiement", nullable = false)
    private LigneConditionPaiement conditionPaiement;

}