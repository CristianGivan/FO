package com.app.FO.controller;


import com.app.FO.dto.user.UserDTO;
import com.app.FO.dto.user.UserRoleDTO;
import com.app.FO.mapper.UserDTOMapper;
import com.app.FO.mapper.UserRoleDTOMapper;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserRole;
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
/*//only for test mappr ur
    @Autowired
    UserRoleDTOMapper userRoleDTOMapper;*/
    @Autowired
    UserDTOMapper userDTOMapper;
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

/*// am folosit sa rezolv problema cu rolul userilor

    @GetMapping("/test1")
    public List<UserRoleDTO> getLogInUserTest1(){
        User user =userService.findUserById(3l);
        List<UserRole> userRoles =user.getUserRoles();
        List<UserRoleDTO> userRoleDTO =userRoleDTOMapper.UserRolesToUserRolesDTO(userRoles);
        System.out.println(userRoles);
        System.out.println(userRoleDTO);
//        return userService.getLogInUserDTO();
        return userRoleDTO;
    }  @GetMapping("/test2")
    public UserDTO getLogInUserTest2(){
        User user =userService.findUserById(3l);
        List<UserRole> userRoles =user.getUserRoles();
        List<UserRoleDTO> userRoleDTO =userRoleDTOMapper.UserRolesToUserRolesDTO(userRoles);
        System.out.println(userRoles);
        System.out.println(userRoleDTO);
        return userDTOMapper.UserToUserDTO(user);
    }
*/



}
