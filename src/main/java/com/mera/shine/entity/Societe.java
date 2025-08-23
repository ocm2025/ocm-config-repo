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
@Table(name = "societe")
public class Societe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "s_nom", nullable = false)
    private String sNom;

    @Size(max = 255)
    @NotNull
    @Column(name = "s_activite", nullable = false)
    private String sActivite;

    @Size(max = 255)
    @Column(name = "s_adresse")
    private String sAdresse;

    @Size(max = 255)
    @Column(name = "s_boite_postal")
    private String sBoitePostal;

    @Size(max = 255)
    @NotNull
    @Column(name = "s_pays", nullable = false)
    private String sPays;

    @Size(max = 255)
    @Column(name = "s_region")
    private String sRegion;

    @Size(max = 255)
    @Column(name = "s_telephone")
    private String sTelephone;

    @Size(max = 255)
    @NotNull
    @Column(name = "s_nc", nullable = false)
    private String sNc;

    @Size(max = 255)
    @NotNull
    @Column(name = "s_rccm", nullable = false)
    private String sRccm;

    @Size(max = 255)
    @NotNull
    @Column(name = "s_regime_fiscal", nullable = false)
    private String sRegimeFiscal;

    @Size(max = 255)
    @NotNull
    @Column(name = "s_devise", nullable = false)
    private String sDevise;

    @Size(max = 255)
    @Column(name = "s_logo")
    private String sLogo;

    @Size(max = 255)
    @Column(name = "s_fovicon")
    private String sFovicon;

    @OneToMany(mappedBy = "societe")
    private Set<Parametre> parametres = new LinkedHashSet<>();

}