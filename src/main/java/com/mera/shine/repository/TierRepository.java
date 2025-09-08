package com.mera.shine.repository;

import com.mera.shine.entity.Site;
import com.mera.shine.entity.Tier;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the Tier entity.
 */
@Repository
public interface TierRepository extends JpaRepository<Tier, Integer> {


    List<Tier> findByClTypeAndSocieteId(Integer clType, Integer societeId);

    @Query("SELECT t FROM Tier t JOIN TiersToSite ts ON t.id = ts.tiers.id WHERE t.clType = :clType AND ts.site.id = :siteId")
    List<Tier> findByClTypeAndSiteId(@Param("clType") Integer clType, @Param("siteId") Integer siteId);
}
