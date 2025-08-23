package com.mera.shine.repository;

import com.mera.shine.entity.UniteMesure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the UniteMesure entity.
 */
@Repository
public interface UniteMesureRepository extends JpaRepository<UniteMesure, Integer> {

}