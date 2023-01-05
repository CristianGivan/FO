package com.app.FO.controller;


import com.app.FO.dto.user.UserDTO;
import com.app.FO.model.user.User;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public List<UserDTO> findAllUsers(){
        return userService.findAllUsersDTO();
    }
    @GetMapping("/getLogInUser")
    public UserDTO getLogInUser(){
        return userService.getLogInUserDTO();
    }

}
