package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "unite_mesure")
public class UniteMesure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "um_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "um_code", nullable = false)
    private String umCode;

    @Size(max = 255)
    @NotNull
    @Column(name = "um_libelle", nullable = false)
    private String umLibelle;

    @NotNull
    @Column(name = "um_is_reference", nullable = false)
    private Integer umIsReference;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "societe", nullable = false)
    private Societe societe;

}