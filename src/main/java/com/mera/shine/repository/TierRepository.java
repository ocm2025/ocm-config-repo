package com.mera.shine.repository;

import com.mera.shine.entity.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the Tier entity.
 */
@Repository
public interface TierRepository extends JpaRepository<Tier, Integer> {

}