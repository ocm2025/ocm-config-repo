package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "parametres")
public class Parametre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cs_id", nullable = false)
    private Integer id;

    @Size(max = 12)
    @NotNull
    @Column(name = "cs_code", nullable = false, length = 12)
    private String csCode;

    @Size(max = 255)
    @Column(name = "cs_libelle")
    private String csLibelle;

    @Column(name = "cs_is_valid")
    private Byte csIsValid;

    @Size(max = 100)
    @Column(name = "cs_value")
    private String csvalue;

    @Size(max = 255)
    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "societe")
    private Societe societe;

    @ManyToOne
    @JoinColumn(name = "site")
    private Site site;

}