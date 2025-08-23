package com.mera.shine.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "language_translations")
public class LanguageTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "lang_id", nullable = false)
    private Integer langId;

    @Size(max = 100)
    @NotNull
    @Column(name = "lang_key", nullable = false, length = 100)
    private String langKey;

    @Column(name = "lang_value", columnDefinition = "TEXT")
    private String langValue;

}
