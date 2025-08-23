package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "adresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "af_id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "af_type", nullable = false)
    private Short afType;

    @Size(max = 255)
    @Column(name = "af_rue")
    private String afRue;

    @Size(max = 255)
    @Column(name = "af_ville")
    private String afVille;

    @Size(max = 255)
    @Column(name = "af_pays")
    private String afPays;

    @Size(max = 255)
    @Column(name = "af_code_postal")
    private String afCodePostal;

    @ManyToOne
    @JoinColumn(name = "tiers")
    private Tier tiers;

}