package com.app.FO.service.user;


import com.app.FO.dto.user.RegisterDTO;
import com.app.FO.dto.user.UserDTO;
import com.app.FO.dto.user.UserFDTO;
import com.app.FO.exceptions.UserNotFoundException;
import com.app.FO.mapper.UserDTOMapper;
import com.app.FO.model.user.Role;
import com.app.FO.model.user.RoleType;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserRole;
import com.app.FO.repository.user.UserRepository;
import com.app.FO.repository.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
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
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository,
                       RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    //-- GET

    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException("User not found"));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<UserDTO> findAllUsersDTO(){
        return userDTOMapper.UsersToUsersDTO(findAllUsers());
    }
    public List<UserFDTO> findAllUsersFDTO(){
        return userDTOMapper.UsersToUsersFDTO(findAllUsers());
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getLogInUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User foundUser=userRepository.findByUsername(userDetails.getUsername());
        return foundUser;
    }

    public UserDTO getLogInUserDTO(){
        return userDTOMapper.UserToUserDTO(getLogInUser());
    }
    public UserFDTO getLogInUserFDTO(){
        return userDTOMapper.UserToUserFDTO(getLogInUser());
    }
    public UserFDTO getUserFDTOByUsername(String username){
        return userDTOMapper.UserToUserFDTO(getUserByUsername(username));
    }

    //-- Set


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User registerStandardUser(RegisterDTO newUser) throws ResponseStatusException {
        User user = userRepository.findByUsername(newUser.getUsername());
        if (user != null) {
            throw new ResponseStatusException(HttpStatus.CREATED, "User already exist");
        }
        user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        Role role = roleService.findRoleByType(RoleType.ROLE_CLIENT);
        UserRole userRole = new UserRole(user, role, LocalDateTime.now());
        role.getUserRoleList().add(userRole);
        user.getUserRoleList().add(userRole);
        userRoleRepository.save(userRole);
        return user;
    }
    public UserFDTO registerStandardUserFDTO(RegisterDTO newUser){
        return userDTOMapper.UserToUserFDTO(registerStandardUser(newUser));
    }

    //--Delete
    public List<User> deleteUserByUserId (Long userId){
        userRepository.delete(findUserById(userId));
        return findAllUsers();
    }
    public List<User> deleteUserDTOByUsername (String username){
        userRepository.delete(getUserByUsername(username));
        return findAllUsers();
    }



    //-- Other






}
