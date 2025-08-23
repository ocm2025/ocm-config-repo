package com.mera.shine.repository;

import com.mera.shine.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the Group entity.
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

}