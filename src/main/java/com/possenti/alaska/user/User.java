package com.possenti.alaska.user;

import com.possenti.alaska.util.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author Rafael Possenti
 * @since 2020-02-25
 */
@Entity
@Table(name = "`user`")
public class User extends BaseEntity {

    @NotNull
    @Size(max = 255)
    private String name;

    private String image;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }
}
