package com.possenti.alaska.util;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Rafael Possenti
 * @since 2020-02-25
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    /**
     * Method to handle records before insertions.
     *
     * Fields {@link BaseEntity#createdAt} and {@link BaseEntity#updatedAt} always must be created by server before insert.
     */
    @PrePersist
    public void prePersist() {
        final LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    /**
     * Method to handle records before updates.
     *
     * Field {@link BaseEntity#updatedAt} always must be set by server before any update.
     */
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
