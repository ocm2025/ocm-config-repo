package com.mera.shine.repository;

import com.mera.shine.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the Currency entity.
 */
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}