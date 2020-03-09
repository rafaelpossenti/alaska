package com.possenti.alaska.userprofile;

import lombok.Getter;
import lombok.Setter;
import com.possenti.alaska.util.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * @author Rafael Possenti
 * @since 2020-02-25
 */
@Entity
@Getter
@Setter
public class UserProfile extends BaseEntity {

    @NotNull
    @Size(max = 255)
    private String name;

    private String image;
}
