package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "zone_distribution")
public class ZoneDistribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zd_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "zd_code", nullable = false)
    private String zdCode;

    @Size(max = 255)
    @Column(name = "zd_libelle")
    private String zdLibelle;

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;


}