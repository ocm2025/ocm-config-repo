package com.mera.shine.repository;

import com.mera.shine.entity.GroupsRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the GroupsRole entity.
 */
@Repository
public interface GroupsRoleRepository extends JpaRepository<GroupsRole, Integer> {

    @Query("SELECT gr FROM GroupsRole gr WHERE gr.idgroup.id = :idGroup")
    List<GroupsRole> findByIdGroup(@Param("idGroup") Integer idGroup);
}
