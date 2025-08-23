package com.mera.shine.repository;

import com.mera.shine.entity.CurrencyToSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the CurrencyToSite entity.
 */
@Repository
public interface CurrencyToSiteRepository extends JpaRepository<CurrencyToSite, Integer> {

}