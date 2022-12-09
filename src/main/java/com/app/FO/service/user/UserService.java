package com.app.FO.service.user;


import com.app.FO.dto.user.RegisterDTO;
import com.app.FO.exceptions.UserNotFoundException;
import com.app.FO.model.user.Role;
import com.app.FO.model.user.RoleType;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserRole;
import com.app.FO.repository.user.UserRepository;
import com.app.FO.repository.user.UserRoleRepository;
import com.app.FO.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository,
                       RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException("User not found"));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User registerStandardUser(RegisterDTO newUser) throws ResponseStatusException {
        User user = userRepository.findByUsername(newUser.getUsername());
        if (user != null) {
            throw new ResponseStatusException(HttpStatus.CREATED, "already exist");
        }
        user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        Role role = roleService.findRoleByType(RoleType.ROLE_CLIENT);
        UserRole userRole = new UserRole(user, role, LocalDateTime.now());
        role.getUserRoles().add(userRole);
        user.getUserRoles().add(userRole);
        userRoleRepository.save(userRole);
        return user;
    }
}
