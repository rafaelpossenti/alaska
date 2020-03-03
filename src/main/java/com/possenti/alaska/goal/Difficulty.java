package com.possenti.alaska.goal;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.util.StringUtils;

/**
 * @author Rafael Possenti
 * @since 2020-03-03
 */
public enum Difficulty {
    TRAINING,
    EASY,
    MODERATE,
    HARD,
    INSANE,
    UNKNOWN;

    /**
     * Create a enum with case insensitive on name. If the name can not be
     * converted, it will return UNKNOWN and must be resolved in the
     * logic validator.
     *
     * @param difficulty to handle the conversion
     */
    @JsonCreator
    public static Difficulty fromString(final String difficulty) {
        try {
            return StringUtils.isEmpty(difficulty) ? null : Difficulty.valueOf(difficulty.trim().toUpperCase());
        } catch (final IllegalArgumentException e) {
            return UNKNOWN;
        }
    }

}
