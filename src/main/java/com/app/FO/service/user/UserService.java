package com.app.FO.service.user;


import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.email.Email;
import com.app.FO.model.user.*;
import com.app.FO.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ServiceAll serviceAll;


    @Autowired
    public UserService(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    //-- Post

    public User postUser(String username, String password, String roleType) {

        User logInUser = getLogInUser();
        if (!userIsAdmin(logInUser)) {
            throw new UserHasNotEnoughPrivileges("The user has not enough rights to create another user");
        }
        User user = userRepository.getUserByUserName(username);
        if (user != null) {
            throw new UserAlreadyExistException("User already exist has id: " + user.getId());
        }
        user = new User(username, passwordEncoder.encode(password));

        Role role;
        if (roleType.equals("admin")) {
            role = roleService.findRoleByType(RoleType.ROLE_ADMIN);
        } else {
            role = roleService.findRoleByType(RoleType.ROLE_STANDARD);
        }

        UserRole userRole = new UserRole(user, role);
        user.getUserRoleList().add(userRole);

        UserUser userAddedToUser = new UserUser(logInUser, user);
        logInUser.getUserUserList().add(userAddedToUser);

        return userRepository.save(user);
    }

    //-- Put

    public User putUsernameToLogInUser(String username) {
        User logInUser = serviceAll.getLogInUser();

        if (logInUser.getUsername().equals(username)) {
            throw new UserAlreadyExistException("User has already the same username");
        }

        logInUser.setUsername(username);

        return userRepository.save(logInUser);
    }

    public User putPasswordToLogInUser(String password) {

        User logInUser = serviceAll.getLogInUser();

        logInUser.setPassword(passwordEncoder.encode(password));
        return userRepository.save(logInUser);
    }

    public User putEmailToLogInUser(Long emailId) {
        User logInUser = getLogInUser();
        if (!userIsAdmin(logInUser)) {
            throw new UserHasNotEnoughPrivileges("The user has not enough rights to create another user");
        }

        Email email = serviceAll.getEmailFromUserIdAndEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found");
        }

        logInUser.setEmail(email);
        return userRepository.save(logInUser);
    }

    public User putUserToLogInUser(Long userId) {

        User logInUser = getLogInUser();

        User userToBeAdded = userRepository.getUserByUserId(userId);
        if (userToBeAdded == null) {
            throw new UserNotFoundException("User not found");
        }
        UserUser userUser = serviceAll.getUserUserByUserIdAndUserId(logInUser.getId(), userToBeAdded.getId());
        if (userUser != null) {
            throw new UserAlreadyExistException("User already exist (id from linking table is: " + userUser.getId() + ")");
        }

        UserUser userAddedToUser = new UserUser(logInUser, userToBeAdded);

        logInUser.getUserUserList().add(userAddedToUser);
        return userRepository.save(logInUser);
    }

    public User putRoleToUser(Long userId, String roleType) {

        User logInUser = getLogInUser();
        if (!userIsAdmin(logInUser)) {
            throw new UserHasNotEnoughPrivileges("The user has not enough rights to create another user");
        }

        User user = userRepository.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        Role role;
        if (roleType.equals("admin")) {
            role = roleService.findRoleByType(RoleType.ROLE_ADMIN);
        } else {
            role = roleService.findRoleByType(RoleType.ROLE_STANDARD);
        }

        UserRole userRole = serviceAll.getUserRoleByUserIdAndRoleId(userId, role.getId());
        if (userRole != null) {
            throw new UserRoleAlreadyExistException("The user already has the role");
        }

        userRole = new UserRole(user, role);
        user.getUserRoleList().add(userRole);

        return userRepository.save(user);
    }
    //--Delete

    public List<User> deleteUserByUserId(Long userId) {
        userRepository.delete(getUserByUserId(userId));
        return getAllUser();
    }

    public User deleteUserFromLogInUser(Long userIdToBeDeleted) {

        User logInUser = getLogInUser();

        User userToBeDeleted = userRepository.getUserByUserId(userIdToBeDeleted);
        if (userToBeDeleted == null) {
            throw new UserNotFoundException("User not found");
        }
        UserUser userUser = serviceAll.getUserUserByUserIdAndUserId(logInUser.getId(), userToBeDeleted.getId());
        if (userUser == null) {
            throw new UserNotFoundException("User is not linked to the log in user");
        }

        logInUser.getUserUserList().remove(userUser);
        return userRepository.save(logInUser);
    }


    public User deleteRoleFromUser(Long userId, String userType) {

        User logInUser = getLogInUser();
        if (!userIsAdmin(logInUser)) {
            throw new UserHasNotEnoughPrivileges("The user has not enough rights to delete user's role");
        }

        User user = userRepository.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        RoleType roleType;
        if (userType.equals("admin")) {
            roleType = RoleType.ROLE_ADMIN;
        } else {
            roleType = RoleType.ROLE_STANDARD;
        }

        Role role = roleService.findRoleByType(roleType);
        if (role == null) {
            throw new RoleNotFoundException("Role not found");
        }

        UserRole userRole = serviceAll.getUserRoleByUserIdAndRoleId(userId, role.getId());
        if (userRole == null) {
            throw new RoleNotFoundException("Role is not linked to the user");
        }

        user.getUserRoleList().remove(userRole);
        return userRepository.save(user);
    }


    //-- GET

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getLogInUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.getUserByUserName(userDetails.getUsername());
    }

    public User getUserByUserId(Long userId) {
        return userRepository.getUserByUserId(userId);
    }

    public List<User> getUserListByUsername(String username) {
        List<User> userList = userRepository.getUserListByUsername(username);

        if (userList.isEmpty()) {
            throw new UserNotFoundException("No user found");
        }
        return userList;
    }

    public List<User> getUserListByUsernameContains(String usernameContains) {
        List<User> userList = userRepository.getUserListFromUserIdByUsernameContains(usernameContains);
        if (userList.isEmpty()) {
            throw new UserNotFoundException("No user found");
        }
        return userList;
    }

    public User getUserByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        User user = userRepository.getUserFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (user == null) {
            throw new UserNotFoundException("No user found");
        }
        return user;
    }

    public List<User> getUserListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<User> userList = userRepository.getUserListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (userList.isEmpty()) {
            throw new UserNotFoundException("No user found");
        }
        return userList;
    }

    public List<User> getUserListByUserId(Long userId) {
        //todo tbr by receiving from query directly the list of users
//        return userRepository.getUsersByUserList_User(getUserByUserId(userId));
//        return userRepository.getUserListByUserId(userId);
//        List<Long> userIdList = userRepository.getUserIdListByUserId(userId);
//        List<User> userList = userIdList.stream().map(this::getUserByUserId).toList();
        List<User> userList = userRepository.getUserListByUserId(userId);
        if (userList.isEmpty()) {
            throw new UserNotFoundException("No user found");
        }
        return userList;
    }

    public List<User> getUserListByEmail(Long emailId) {
        List<User> userList = userRepository.getUserListByEmailId(emailId);
        if (userList.isEmpty()) {
            throw new UserNotFoundException("No user found");
        }
        return userList;
    }

    public List<User> getUserListByRole(String userType) {
        Role role;
        if (userType.equals("admin")) {
            role = roleService.findRoleByType(RoleType.ROLE_ADMIN);
        } else {
            role = roleService.findRoleByType(RoleType.ROLE_STANDARD);
        }
        List<User> userList = userRepository.getUserListByRole(role.getId());
        if (userList.isEmpty()) {
            throw new UserNotFoundException("No user found");
        }
        return userList;
    }
    //-- Other

    public Boolean userIsAdmin(User user) {
        Boolean isAdminRole = user.getUserRoleList().stream().
                map(userRole -> userRole.getRole().getRoleType().toString()).
                filter(t -> t == "ROLE_ADMIN").findAny().isPresent();
        if (isAdminRole) {
            return true;
        }
        return false;
    }

    public Boolean checkIsUserWithUserName(String username) {
        User user = userRepository.getUserByUserName(username);
        if (user != null) {
            throw new UserAlreadyExistException("User already exist has id: " + user.getId());
        }
        return true;
    }

}
