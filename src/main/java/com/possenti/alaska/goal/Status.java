package com.possenti.alaska.goal;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.util.StringUtils;

/**
 * @author Rafael Possenti
 * @since 2020-03-03
 */
public enum Status {
    PROGRESS,
    CLOSED,
    CANCELED,
    UNKNOWN;

    /**
     * Create a enum with case insensitive on name. If the name can not be
     * converted, it will return UNKNOWN and must be resolved in the
     * logic validator.
     *
     * @param status to handle the conversion
     */
    @JsonCreator
    public static Status fromString(final String status) {
        try {
            return StringUtils.isEmpty(status) ? null : Status.valueOf(status.trim().toUpperCase());
        } catch (final IllegalArgumentException e) {
            return UNKNOWN;
        }
    }

}
