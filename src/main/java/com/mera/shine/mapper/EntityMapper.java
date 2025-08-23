package com.mera.shine.mapper;

/**
 * Generic mapper interface for converting between entities and DTOs.
 *
 * @param <E> Entity type
 * @param <D> DTO type
 * @param <C> Create DTO type
 */
public interface EntityMapper<E, D, C> {

    /**
     * Convert entity to DTO
     *
     * @param entity Entity to convert
     * @return Converted DTO
     */
    D toDto(E entity);

    /**
     * Convert DTO to entity
     *
     * @param dto DTO to convert
     * @return Converted entity
     */
    E toEntity(D dto);

    /**
     * Convert create DTO to entity
     *
     * @param createDto Create DTO to convert
     * @return Converted entity
     */
    E createDtoToEntity(C createDto);

    /**
     * Update entity from DTO
     *
     * @param dto DTO with updated values
     * @param entity Entity to update
     * @return Updated entity
     */
    E updateEntityFromDto(D dto, E entity);
}