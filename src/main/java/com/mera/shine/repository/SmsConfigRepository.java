package com.mera.shine.repository;

import com.mera.shine.entity.SmsConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the SmsConfig entity.
 */
@Repository
public interface SmsConfigRepository extends JpaRepository<SmsConfig, Integer> {

}