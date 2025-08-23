package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_action", nullable = false)
    private Integer id;

    @Column(name = "code")
    private Integer code;

    @Size(max = 255)
    @Column(name = "libelle")
    private String libelle;

}