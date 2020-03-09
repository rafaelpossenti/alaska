package com.possenti.alaska.user;

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
public class UserValidator implements Validator {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean supports(final Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        User user = (User) target;

        this.isDuplicated(user, errors);

    }

    private void isDuplicated(final User user, final Errors errors) {
        final boolean duplicated = userRepository.findAll().stream().anyMatch(item -> item.getName().equals(user.getName()));
        if (duplicated) {
            errors.rejectValue("name", "register.duplicated");
        }
    }

}
