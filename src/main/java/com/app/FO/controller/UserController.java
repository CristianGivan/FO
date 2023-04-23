package com.app.FO.controller;


import com.app.FO.dto.general.TextDTO;
import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.user.RegisterDTO;
import com.app.FO.dto.user.UserDTO;
import com.app.FO.dto.user.UserFDTO;
import com.app.FO.dto.user.UserRoleDTO;
import com.app.FO.mapper.UserDTOMapper;
import com.app.FO.mapper.UserRoleDTOMapper;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserRole;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    UserDTOMapper userDTOMapper;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //-- GetMapping

    @GetMapping("/getLogInUser")
    public UserDTO getLogInUser(){
        return userService.getLogInUserDTO();
    }

    @GetMapping("/getLogInUserF")
    public UserFDTO getLogInUserF(){
        return userService.getLogInUserFDTO();
    }

    @GetMapping("/getUserFDTOByUsername/{username}")
    public UserFDTO getUserFDTOByUsername(@PathVariable String username){
        return userService.getUserFDTOByUsername(username);
    }

    @GetMapping("/findAll")
    public List<UserDTO> findAllUsers(){
        return userService.findAllUsersDTO();
    }

    @GetMapping("/getUserListByNoteId/{noteId}")
    public List<UserDTO> getUserListByNoteId(@PathVariable Long noteId){
        List<User> userList=userService.getUserListByNoteId(noteId);
        return userDTOMapper.UsersToUsersDTO(userList);
    }


    //-- PostMapping
    @PostMapping("/registerStandardUser")
    public UserFDTO registerStandardUser(@RequestBody RegisterDTO newUser) {
        UserFDTO userFDTO=userService.registerStandardUserFDTO(newUser);
        return userFDTO;
    }

    //-- PutMapping


    //-- DeleteMapping

    @DeleteMapping("/deleteUserDTOByUserId/{userId}")
    public List<UserDTO> deleteUserDTOByUserId(@PathVariable Long userId) {
        userService.deleteUserByUserId(userId);
        return userService.findAllUsersDTO();
    }
    @DeleteMapping("/deleteUserFDTOByUserId/{username}")
    public List<UserFDTO> deleteUserFDTOByUsername(@PathVariable String username) {
        userService.deleteUserDTOByUsername(username);
//        return userService.findAllUsersDTO();
        return userService.findAllUsersFDTO();
    }

    //--- Other







}
