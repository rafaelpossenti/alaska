package com.possenti.alaska.goal;

import com.possenti.alaska.GoalType.GoalType;
import com.possenti.alaska.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Rafael Possenti
 * @since 2020-03-01
 */
@Entity
@Getter
@Setter
public class Goal extends BaseEntity {

    @NotNull
    @Size(max = 80)
    private String name;

    @Size(max = 255)
    private String description;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Frequency frequency;

    @NotNull
    @ManyToOne
//    @JoinColumn(name = "goal_type_id", referencedColumnName = "goal_type_id")
    private GoalType goalType;

}
