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
@Table(name = "site")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pv_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "pv_nom", nullable = false)
    private String pvNom;

    @Size(max = 20)
    @NotNull
    @Column(name = "pv_code", nullable = false, length = 20)
    private String pvCode;

    @Size(max = 255)
    @Column(name = "pv_description")
    private String pvDescription;

    @Size(max = 255)
    @Column(name = "pv_ville")
    private String pvVille;

    @Size(max = 255)
    @Column(name = "pv_pays")
    private String pvPays;

    @NotNull
    @Column(name = "pv_get_emplacement", nullable = false)
    private Short pvGetEmplacement;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "societe", nullable = false)
    private Societe societe;

    @OneToMany(mappedBy = "site")
    private Set<Emplacement> emplacements = new LinkedHashSet<>();

    @OneToMany(mappedBy = "site")
    private Set<Parametre> parametres = new LinkedHashSet<>();

}