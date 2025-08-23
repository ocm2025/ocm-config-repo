package com.mera.shine.repository;

import com.mera.shine.entity.ModepaiementToSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the ModepaiementToSite entity.
 */
@Repository
public interface ModepaiementToSiteRepository extends JpaRepository<ModepaiementToSite, Integer> {

}