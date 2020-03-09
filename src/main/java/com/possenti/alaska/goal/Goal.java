package com.possenti.alaska.goal;

import com.possenti.alaska.goaltype.GoalType;
import com.possenti.alaska.user.User;
import com.possenti.alaska.util.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Rafael Possenti
 * @since 2020-03-01
 */
@Entity
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
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @NotNull
    @ManyToOne
    private GoalType type;

    @JoinTable(
        name = "goal_user",
        joinColumns = @JoinColumn(name = "goal_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<User> users;

    /**
     * @see BaseEntity#prePersist()
     */
    @PrePersist
    @Override
    public void prePersist() {
        super.prePersist();
        this.status = Status.PROGRESS;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(final Frequency frequency) {
        this.frequency = frequency;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(final Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public GoalType getType() {
        return type;
    }

    public void setType(final GoalType type) {
        this.type = type;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(final List<User> users) {
        this.users = users;
    }
}
