package com.mera.shine.repository;

import com.mera.shine.entity.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

/**
 * Repository for the LoginLog entity.
 */
@Repository
public interface LoginLogRepository extends JpaRepository<LoginLog, Integer> {

}