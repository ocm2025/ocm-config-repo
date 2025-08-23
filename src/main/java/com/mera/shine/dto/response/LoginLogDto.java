package com.mera.shine.dto.response;

import java.time.Instant;

/**
 * DTO for {@link com.mera.shine.entity.LoginLog}
 */
public record LoginLogDto(
    Integer id,
    Integer userId,
    String username,
    String ip,
    Instant createdAt
) {
}