package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sms_config")
public class SmsConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsms", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "Sender_Id", length = 20)
    private String senderId;

    @Size(max = 20)
    @Column(name = "Auth_Key", length = 20)
    private String authKey;

    @NotNull
    @Column(name = "Contact", nullable = false)
    private Integer contact;

    @Column(name = "societe")
    private Integer societe;

}