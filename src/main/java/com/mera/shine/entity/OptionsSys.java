package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "options_sys")
public class OptionsSys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "os_id", nullable = false)
    private Integer id;

    @Size(max = 12)
    @NotNull
    @Column(name = "os_code", nullable = false, length = 12)
    private String osCode;

    @Size(max = 255)
    @Column(name = "os_libelle")
    private String osLibelle;

    @Size(max = 255)
    @Column(name = "os_message")
    private String osMessage;

}