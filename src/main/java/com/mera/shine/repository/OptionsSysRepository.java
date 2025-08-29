package com.mera.shine.repository;

import com.mera.shine.entity.OptionsSys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the OptionsSys entity.
 */
@Repository
public interface OptionsSysRepository extends JpaRepository<OptionsSys, Integer> {

}