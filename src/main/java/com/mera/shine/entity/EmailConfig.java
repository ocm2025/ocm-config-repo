package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "email_config")
public class EmailConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "host", length = 20)
    private String host;

    @NotNull
    @Column(name = "port", nullable = false)
    private Integer port;

    @NotNull
    @Column(name = "auth", nullable = false)
    private Byte auth;

    @Size(max = 20)
    @NotNull
    @Column(name = "auth_type", nullable = false, length = 20)
    private String authType;

    @Size(max = 20)
    @NotNull
    @Column(name = "Username", nullable = false, length = 20)
    private String username;

    @Size(max = 20)
    @NotNull
    @Column(name = "password_txt", nullable = false, length = 20)
    private String passwordTxt;

    @Size(max = 20)
    @NotNull
    @Column(name = "from_adress", nullable = false, length = 20)
    private String fromAdress;

    @Size(max = 50)
    @Column(name = "from_name", length = 50)
    private String fromName;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "societe")
    private Societe societe;

}