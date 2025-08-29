package com.mera.shine.dto.response;

/**
 * DTO for {@link com.mera.shine.entity.OptionsSys}
 */
public record OptionsSysDto(
    Integer id,
    String osCode,
    String osLibelle,
    String osMessage
) {
}