package com.mera.shine.repository;

import com.mera.shine.entity.GroupsRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the GroupsRole entity.
 */
@Repository
public interface GroupsRoleRepository extends JpaRepository<GroupsRole, Integer> {

}