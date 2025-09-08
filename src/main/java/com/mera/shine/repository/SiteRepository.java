package com.mera.shine.repository;

import com.mera.shine.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for the Site entity.
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {

    /**
     * Find all sites by société ID.
     *
     * @param societeId the ID of the société
     * @return list of sites belonging to the société
     */
    List<Site> findBySocieteId(Integer societeId);
}
