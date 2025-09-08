package com.mera.shine.repository;

import com.mera.shine.entity.SmsConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the SmsConfig entity.
 */
@Repository
public interface SmsConfigRepository extends JpaRepository<SmsConfig, Integer> {

    @Query("SELECT s FROM SmsConfig s WHERE s.societe = :societeId")
    List<SmsConfig> findBySocieteId(@Param("societeId") Integer societeId);
}
