package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "emplacement")
public class Emplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "em_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "em_nom", nullable = false)
    private String emNom;

    @Size(max = 12)
    @NotNull
    @Column(name = "em_code", nullable = false, length = 12)
    private String emCode;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "site", nullable = false)
    private Site site;

}