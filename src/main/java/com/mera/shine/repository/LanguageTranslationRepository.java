package com.mera.shine.repository;

import com.mera.shine.entity.LanguageTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the LanguageTranslation entity.
 */
@Repository
public interface LanguageTranslationRepository extends JpaRepository<LanguageTranslation, Integer> {

}