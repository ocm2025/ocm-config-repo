package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "login_logs")
public class LoginLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Size(max = 100)
    @Column(name = "username", length = 100)
    private String username;

    @Size(max = 50)
    @Column(name = "ip", length = 50)
    private String ip;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}