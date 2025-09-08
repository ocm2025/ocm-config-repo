package com.mera.shine.repository;

import com.mera.shine.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the Adresse entity.
 */
@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
    
    List<Adresse> findByTiersId(Integer tiersId);
}