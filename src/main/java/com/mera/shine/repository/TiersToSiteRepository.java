package com.mera.shine.repository;

import com.mera.shine.entity.TiersToSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the TiersToSite entity.
 */
@Repository
public interface TiersToSiteRepository extends JpaRepository<TiersToSite, Integer> {

}