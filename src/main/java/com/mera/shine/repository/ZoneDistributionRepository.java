package com.mera.shine.repository;

import com.mera.shine.entity.ZoneDistribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the ZoneDistribution entity.
 */
@Repository
public interface ZoneDistributionRepository extends JpaRepository<ZoneDistribution, Integer> {

    List<ZoneDistribution> findBySiteId(Integer siteId);
}