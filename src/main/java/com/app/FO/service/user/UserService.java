package com.app.FO.service.user;


import com.app.FO.exceptions.UserNotFoundException;
import com.app.FO.mapper.dto.user.RegisterDTO;
import com.app.FO.mapper.mappers.UserDTOMapper;
import com.app.FO.model.user.Role;
import com.app.FO.model.user.RoleType;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserRole;
import com.app.FO.repository.user.UserRepository;
import com.app.FO.repository.user.UserRoleRepository;
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
    private UserRoleRepository userRoleRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDTOMapper userDTOMapper;
    @Autowired
    private ChecksUser checksUser;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository,
                       RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
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
        checksUser.checkUserHasPermission(getLogInUser());
        checksUser.checkIsUserWithUserName(newUser.getUsername());
        User user = new User(newUser.getUsername(), passwordEncoder.encode(newUser.getPassword()));
        Role role;
        if (newUser.getRole().equals("admin")) {
            role = roleService.findRoleByType(RoleType.ROLE_ADMIN);
        } else {
            role = roleService.findRoleByType(RoleType.ROLE_STANDARD);
        }
        UserRole userRole = new UserRole(user, role);
        user.getUserRoleList().add(userRole);
        userRoleRepository.save(userRole);
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

    //-- GET

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User getLogInUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
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

    //--Delete


    //-- Other


    //--Delete
    public List<User> deleteUserByUserId(Long userId) {
        userRepository.delete(getUserByUserId(userId));
        return findAllUsers();
    }

    public List<User> deleteUserDTOByUsername(String username) {
        userRepository.delete(getUserByUsername(username));
        return findAllUsers();
    }

}
