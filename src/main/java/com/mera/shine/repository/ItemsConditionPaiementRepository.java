package com.mera.shine.repository;

import com.mera.shine.entity.ItemsConditionPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the ItemsConditionPaiement entity.
 */
@Repository
public interface ItemsConditionPaiementRepository extends JpaRepository<ItemsConditionPaiement, Integer> {
    
}