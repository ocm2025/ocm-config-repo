package com.mera.shine.repository;

import com.mera.shine.entity.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the EmailConfig entity.
 */
@Repository
public interface EmailConfigRepository extends JpaRepository<EmailConfig, Integer> {

    EmailConfig findBySocieteId(Integer societeId);
}