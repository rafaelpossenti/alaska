package com.possenti.alaska.goaltype;

import com.possenti.alaska.util.BaseEntity;
import org.springframework.lang.NonNull;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Rafael Possenti
 * @since 2020-03-01
 */
@Entity
public class GoalType extends BaseEntity {

    @NotNull
    private String type;

    @NonNull
    @Size(max = 255)
    private String description;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}
