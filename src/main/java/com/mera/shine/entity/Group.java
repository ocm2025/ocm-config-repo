package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private Integer type;

    @Column(name = "is_active")
    private Integer isActive;

    @ManyToOne
    @JoinColumn(name = "societe")
    private Societe societe;

    @OneToMany(mappedBy = "idgroup")
    private Set<GroupsRole> groupsRoles = new LinkedHashSet<>();

}