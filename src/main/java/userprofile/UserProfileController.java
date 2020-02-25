package userprofile;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Rafael Possenti
 * @since 2020-02-25
 */
@RestController
public class UserProfileController {

    private final UserProfileRepository repository;

    public UserProfileController(final UserProfileRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user-profiles")
    List<UserProfile> list() {
        return repository.findAll();
    }

    @PostMapping("/user-profiles")
    public void insert(@RequestBody UserProfile user) {
        this.repository.save(user);
    }
}
