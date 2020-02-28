package com.possenti.alaska.userprofile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Rafael Possenti
 * @since 2020-02-28
 */
@Component
public class UserProfileValidator implements Validator {

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    public boolean supports(final Class<?> clazz) {
        return UserProfile.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        UserProfile userProfile = (UserProfile) target;
        final boolean duplicated = userProfileRepository.findAll().stream().anyMatch(item -> item.getName().equals(userProfile.getName()));
        if (duplicated) {
            errors.rejectValue("name", "register.duplicated");
        }
    }
}
