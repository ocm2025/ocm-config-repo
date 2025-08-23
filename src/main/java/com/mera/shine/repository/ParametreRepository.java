package com.mera.shine.repository;

import com.mera.shine.entity.Parametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the Parametre entity.
 */
@Repository
public interface ParametreRepository extends JpaRepository<Parametre, Integer> {

}