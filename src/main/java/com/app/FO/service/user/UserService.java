package com.app.FO.service.user;


import com.app.FO.exceptions.RoleNotFoundException;
import com.app.FO.exceptions.UserAlreadyExistException;
import com.app.FO.exceptions.UserHasNotEnoughPrivileges;
import com.app.FO.exceptions.UserNotFoundException;
import com.app.FO.mapper.dto.user.RegisterDTO;
import com.app.FO.model.user.*;
import com.app.FO.repository.user.UserRepository;
import com.app.FO.util.ChecksUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //ToDo ii corect ce am facut aici ca a mai facut un repository static? Ca sa pot sa creez o metoda statica
    // pentru a putea accesa peste tot unde am nevoie doar metoda statica pe clasa fara a mai fi nevoie de a injecta peste totot clasa UserService
    // @Autowired
    // private static UserRepository userRepositoryStatic;
    private UserRepository userRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ChecksUser checksUser;

    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserUserService userUserService;


    @Autowired
    public UserService(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    //-- Post

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User postUser(RegisterDTO newUser) {
        /*
        - Verifies if the log in user has the admin role
        - Verifies if the user all ready exist
        - Add role to user
        - Save Role
        */
        User logInUser = getLogInUser();
        if (!userIsAdmin(logInUser)) {
            throw new UserHasNotEnoughPrivileges("The user has not enough rights to create another user");
        }
        User user = userRepository.getUserByUserName(newUser.getUsername());
        if (user != null) {
            throw new UserAlreadyExistException("User already exist has id: " + user.getId());
        }
        user = new User(newUser.getUsername(), passwordEncoder.encode(newUser.getPassword()));

        Role role;
        if (newUser.getRole().equals("admin")) {
            role = roleService.findRoleByType(RoleType.ROLE_ADMIN);
        } else {
            role = roleService.findRoleByType(RoleType.ROLE_STANDARD);
        }

        UserRole userRole = new UserRole(user, role);
        user.getUserRoleList().add(userRole);

        UserUser userAddedToUser = new UserUser(logInUser, user);
        logInUser.getUserUserList().add(userAddedToUser);
        userRepository.save(user);
        return user;
    }

    //-- Put

    public User putRoleToUser(Long userId, String userType) {
        /*
         - check if the user exist and the user has the type
         - create an user role
         - add user role to user
         - save user
         */
        RoleType roleType;
        if (userType.equals("admin")) {
            roleType = RoleType.ROLE_ADMIN;
        } else {
            roleType = RoleType.ROLE_STANDARD;
        }
        User user = userRepository.getUserByUserId(userId);
        Role role = roleService.findRoleByType(roleType);
        checksUser.checkIsUserAndRoleAndAreNotLinked(user, role);
        UserRole userRole = new UserRole(user, role);
        user.getUserRoleList().add(userRole);
        return userRepository.save(user);
    }

    public User putUsernameToUser(Long userId, String username) {

        User user = userRepository.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        user.setUsername(username);
        return userRepository.save(user);
    }

    public User putPasswordToUser(Long userId, String password) {

        User user = userRepository.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public User putEmailToUser(Long userId, String email) {

        User user = userRepository.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        user.setEmail(email);
        return userRepository.save(user);
    }

    public User putUserToLogInUser(Long userId) {

        User logInUser = getLogInUser();

        User userToBeAdded = userRepository.getUserByUserId(userId);
        if (userToBeAdded == null) {
            throw new UserNotFoundException("User not found");
        }
        UserUser userHasUser = userUserService.getUserUserByUserUserId(logInUser.getId(), userToBeAdded.getId());
        if (userHasUser != null) {
            throw new UserAlreadyExistException("User already exist (id from linking table is: " + userHasUser.getId() + ")");
        }

        UserUser userAddedToUser = new UserUser(logInUser, userToBeAdded);

        logInUser.getUserUserList().add(userAddedToUser);
        return userRepository.save(logInUser);
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

    public User getUserByUsername(String username) {
        return userRepository.getUserByUserName(username);
    }

    public List<User> getUserListByNoteId(Long noteId) {
        /*
         * Every user has a list of users that with witch can share information
         * To have access to other users information it has to request the conses
         * You can have access only for the notes where you are included in the user list
         * Cam be seen the users that are not in your user list? yes but you cannot see there content only if you are included by them int user list of there content
         * */

        //todo tbc checks

        return userRepository.getUserListByNoteId(noteId);
    }

    public List<User> getUserListByTagId(Long tagId) {
        return userRepository.getUserListByTagId(tagId);
    }

    public List<User> getUserListByRole(String userType) {
        Role role;
        if (userType.equals("admin")) {
            role = roleService.findRoleByType(RoleType.ROLE_ADMIN);
        } else {
            role = roleService.findRoleByType(RoleType.ROLE_STANDARD);
        }
        return userRepository.getUserListByRole(role.getId());
    }

    public List<User> getUserListByUserId(Long userId) {
        //todo tbr by receiving from query directly the list of users
//        return userRepository.getUsersByUserList_User(getUserByUserId(userId));
//        return userRepository.getUserListByUserId(userId);
        List<Long> userIdList = userRepository.getUserIdListByUserId(userId);
        List<User> userList = userIdList.stream().map(this::getUserByUserId).toList();
        return userList;
    }


    //--Delete

    public List<User> deleteUserByUserId(Long userId) {
        userRepository.delete(getUserByUserId(userId));
        return getAllUser();
    }

    public User deleteRoleFromUser(Long userId, String userType) {
        /*
         * 1. Find param1 and param2
         * 2. Check if
         *   a. param1 exist
         *   b. param2 exist
         *   c. param2 is at param1
         * 3. Delete param2 from param1
         * 4. Save param1, no needed to save param2 because there is persist*/

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

        UserRole userRole = userRoleService.getUserRoleByUserRoleId(userId, role.getId());
        if (userRole == null) {
            throw new RoleNotFoundException("Role is not linked to the user");
        }

        user.getUserRoleList().remove(userRole);
        return userRepository.save(user);
    }

    public User deleteUserFromLogInUserList(Long userIdToBeDeleted) {
        /*
         * 1. Find param1 and param2
         * 2. Check if
         *   a. param1 exist
         *   b. param2 exist
         *   c. param2 is at param1
         * 3. Delete param2 from param1
         * 4. Save param1, no needed to save param2 because there is persist*/

        User logInUser = getLogInUser();

        User userToBeDeleted = userRepository.getUserByUserId(userIdToBeDeleted);
        if (userToBeDeleted == null) {
            throw new UserNotFoundException("User not found");
        }
        UserUser userHasUser = userUserService.getUserUserByUserUserId(logInUser.getId(), userToBeDeleted.getId());
        if (userHasUser == null) {
            throw new UserNotFoundException("User is not linked to the log in user");
        }

        logInUser.getUserUserList().remove(userHasUser);
        return userRepository.save(logInUser);
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
