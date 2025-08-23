package com.mera.shine.repository;

import com.mera.shine.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for the Language entity.
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}