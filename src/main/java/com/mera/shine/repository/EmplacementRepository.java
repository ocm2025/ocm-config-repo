package com.mera.shine.repository;

import com.mera.shine.entity.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the Emplacement entity.
 */
@Repository
public interface EmplacementRepository extends JpaRepository<Emplacement, Integer> {

}