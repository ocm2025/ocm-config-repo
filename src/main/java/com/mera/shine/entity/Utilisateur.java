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
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "u_nom_prenom", nullable = false)
    private String uNomPrenom;

    @Size(max = 255)
    @Column(name = "u_telephone")
    private String uTelephone;

    @Size(max = 255)
    @Column(name = "u_adresse")
    private String uAdresse;

    @Size(max = 255)
    @NotNull
    @Column(name = "u_user_name", nullable = false)
    private String uUserName;

    @Size(max = 255)
    @NotNull
    @Column(name = "u_password", nullable = false)
    private String uPassword;

    @Size(max = 255)
    @Column(name = "u_email")
    private String uEmail;

    @Size(max = 255)
    @Column(name = "u_pwd_text")
    private String uPwdText;

    @ManyToOne
    @JoinColumn(name = "site")
    private Site site;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "societe", nullable = false)
    private Societe societe;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "groupe")
    private Group groupe;

}