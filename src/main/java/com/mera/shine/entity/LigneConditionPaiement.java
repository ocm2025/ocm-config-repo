package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ligne_condition_paiement")
public class LigneConditionPaiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lcp_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "lcp_nom", nullable = false)
    private String lcpNom;

    @Size(max = 255)
    @Column(name = "lcp_description")
    private String lcpDescription;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "societe", nullable = false)
    private Societe societe;

    @OneToMany(mappedBy = "conditionPaiement")
    private Set<ItemsConditionPaiement> itemsConditionPaiements = new LinkedHashSet<>();

}