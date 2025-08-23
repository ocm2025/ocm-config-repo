package com.mera.shine.mapper;

import com.mera.shine.dto.request.CreateGroupRequestDto;
import com.mera.shine.dto.response.GroupDto;
import com.mera.shine.entity.Group;

/**
 * Mapper for the Group entity and its DTOs.
 */
public interface GroupMapper extends EntityMapper<Group, GroupDto, CreateGroupRequestDto> {
}