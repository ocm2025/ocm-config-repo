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
@Table(name = "tiers")
public class Tier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cl_id", nullable = false)
    private Integer id;

    @Size(max = 25)
    @NotNull
    @Column(name = "cl_code", nullable = false, length = 25)
    private String clCode;

    @Size(max = 255)
    @NotNull
    @Column(name = "cl_nom", nullable = false)
    private String clNom;

    @Size(max = 255)
    @Column(name = "cl_nc")
    private String clNc;

    @Size(max = 255)
    @Column(name = "cl_rccm")
    private String clRccm;

    @Size(max = 255)
    @Column(name = "cl_telephone")
    private String clTelephone;

    @Size(max = 255)
    @Column(name = "cl_email")
    private String clEmail;

    @NotNull
    @Column(name = "cl_statut_fiscal", nullable = false)
    private Integer clStatutFiscal;

    @Size(max = 255)
    @Column(name = "cl_description")
    private String clDescription;

    @NotNull
    @Column(name = "cl_is_defaut", nullable = false)
    private Short clIsDefaut;

    @NotNull
    @Column(name = "cl_type", nullable = false)
    private Integer clType;

    @ManyToOne
    @JoinColumn(name = "condition_paiement")
    private LigneConditionPaiement conditionPaiement;

    @ManyToOne
    @JoinColumn(name = "zone")
    private ZoneDistribution zone;

    @ManyToOne
    @JoinColumn(name = "taxe")
    private Taxe taxe;

    @ManyToOne
    @JoinColumn(name = "groupe")
    private Group groupe;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "societe", nullable = false)
    private Societe societe;

    @OneToMany(mappedBy = "tiers")
    private Set<Adresse> adresses = new LinkedHashSet<>();

}