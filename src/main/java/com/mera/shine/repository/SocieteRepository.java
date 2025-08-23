package com.mera.shine.repository;

import com.mera.shine.entity.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the Societe entity.
 */
@Repository
public interface SocieteRepository extends JpaRepository<Societe, Integer> {

}