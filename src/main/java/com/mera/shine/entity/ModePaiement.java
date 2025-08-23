package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mode_paiement")
public class ModePaiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mp_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "mp_nom", nullable = false)
    private String mpNom;

    @NotNull
    @Column(name = "mp_virgule", nullable = false)
    private Integer mpVirgule;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "societe", nullable = false)
    private Societe societe;

}