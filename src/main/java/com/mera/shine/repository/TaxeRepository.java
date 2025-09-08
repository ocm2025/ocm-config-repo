package com.mera.shine.repository;

import com.mera.shine.entity.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the Taxe entity.
 */
@Repository
public interface TaxeRepository extends JpaRepository<Taxe, Integer> {

    List<Taxe> findBySocieteId(Integer societeId);
}