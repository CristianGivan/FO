package com.app.FO.util;

import com.app.FO.exceptions.*;
import com.app.FO.model.user.Role;
import com.app.FO.model.user.User;
import com.app.FO.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChecksUser {
    private UserRepository userRepository;
    private Checks checks;

    @Autowired
    public ChecksUser(UserRepository userRepository, Checks checks) {
        this.userRepository = userRepository;
        this.checks = checks;

    }

    public Boolean checkIsUserWithUserName(String username) {
        User user = userRepository.getUserByUserName(username);
        if (user != null) {
            throw new UserAlreadyExistException("User already exist has id: " + user.getId());
        }
        return true;
    }

    public void checkUserHasPermission(User user) {
        if (!checks.userIsAdmin(user)) {
//            throw new UserNotFoundException("The user has not enough rights to create another user");
            throw new UserHasNotEnoughPrivileges("The user has not enough rights to create another user");
        }
    }

    public void checkIsUserAndRoleAndAreNotLinked(User user, Role role) {
        if (user == null) {
            throw new UserNotFoundException("User not found");
        } else if (role == null) {
            throw new RoleNotFoundException("Role not found");
        } else if (checks.userHasRole(user, role) != null) {
            throw new RoleAlreadyExistException("Role is already mapped to the user");

        }
    }

}
