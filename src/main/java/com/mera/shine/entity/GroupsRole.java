package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "groups_role")
public class GroupsRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "idgroup", nullable = false)
    private Group idgroup;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "acces", nullable = false)
    private Role acces;

}