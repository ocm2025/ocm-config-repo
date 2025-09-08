package com.mera.shine.repository;

import com.mera.shine.entity.Emplacement;
import com.mera.shine.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the Emplacement entity.
 */
@Repository
public interface EmplacementRepository extends JpaRepository<Emplacement, Integer> {

    /**
     * Find all emplacements by société ID.
     *
     * @param societeId the ID of the société
     * @return list of emplacements belonging to sites of the société
     */
    @Query("SELECT e FROM Emplacement e WHERE e.site.societe.id = :societeId")
    List<Emplacement> findBySocieteId(@Param("societeId") Integer societeId);


    /**
     * Find all emplacements by site ID.
     *
     * @param siteId the ID of the site
     * @return list of emplacements belonging to the site
     */
    List<Emplacement> findBySiteId(Integer siteId);
}
