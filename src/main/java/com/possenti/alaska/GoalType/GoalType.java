package com.possenti.alaska.GoalType;

import com.possenti.alaska.util.BaseEntity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Rafael Possenti
 * @since 2020-03-01
 */
@Entity
@Getter
@Setter
public class GoalType extends BaseEntity {

    @NotNull
    private String type;

    @NonNull
    @Size(max = 255)
    private String description;


}
