package com.possenti.alaska.goal;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.util.StringUtils;

/**
 * @author Rafael Possenti
 * @since 2020-03-01
 */
public enum Frequency {
    DAILY,
    WEEKLY,
    MONTHLY,
    ANNUALLY,
    UNKNOWN;

    /**
     * Create a enum with case insensitive on name. If the name can not be
     * converted, it will return UNKNOWN and must be resolved in the
     * logic validator.
     *
     * @param frequency to handle the conversion
     */
    @JsonCreator
    public static Frequency fromString(final String frequency) {
        try {
            return StringUtils.isEmpty(frequency) ? null : Frequency.valueOf(frequency.trim().toUpperCase());
        } catch (final IllegalArgumentException e) {
            return UNKNOWN;
        }
    }

}
