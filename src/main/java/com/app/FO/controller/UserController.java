package com.app.FO.controller;


import com.app.FO.mapper.dto.user.RegisterDTO;
import com.app.FO.mapper.dto.user.UserDTO;
import com.app.FO.mapper.dto.user.UserFDTO;
import com.app.FO.mapper.mappers.UserDTOMapper;
import com.app.FO.model.user.User;
import com.app.FO.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @Autowired
    private UserDTOMapper userDTOMapper;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //-- PostMapping
    @PostMapping("/postUser")
    public UserFDTO postUser(@RequestBody RegisterDTO newUser) {
        User user = userService.postUser(newUser);
        return userDTOMapper.UserToUserFDTO(user);
    }

    //-- PutMapping

    @PutMapping("/putRoleToUser")
    public UserDTO putRoleToUser(@RequestParam Long userId, @RequestParam String userType) {
        User user = userService.putRoleToUser(userId, userType);
        return userDTOMapper.UserToUserDTO(user);
    }

    @PutMapping("/putUsernameToUser")
    public UserDTO putUsernameToUser(@RequestParam Long userId, @RequestParam String username) {
        User user = userService.putUsernameToUser(userId, username);
        return userDTOMapper.UserToUserDTO(user);
    }

    @PutMapping("/putPasswordToUser")
    public UserDTO putPasswordToUser(@RequestParam Long userId, @RequestParam String password) {
        User user = userService.putPasswordToUser(userId, password);
        return userDTOMapper.UserToUserDTO(user);
    }

    @PutMapping("/putEmailToUser")
    public UserDTO putEmailToUser(@RequestParam Long userId, @RequestParam String email) {
        User user = userService.putEmailToUser(userId, email);
        return userDTOMapper.UserToUserDTO(user);
    }

    @PutMapping("/putUserToLogInUser")
    public UserDTO putUserToLogInUser(@RequestParam Long userId) {
        User user = userService.putUserToLogInUser(userId);
        return userDTOMapper.UserToUserDTO(user);
    }


    //-- GetMapping

    @GetMapping("/getAllUser")
    public List<UserDTO> getAllUser() {
        List<User> userList = userService.getAllUsers();
        return userDTOMapper.UserListToUserDTOList(userList);
    }

    @GetMapping("/getUserById/{userId}")
    public UserFDTO getUserById(@PathVariable Long userId) {
        User user = userService.getUserByUserId(userId);
        return userDTOMapper.UserToUserFDTO(user);
    }

    @GetMapping("/getLogInUser")
    public UserDTO getLogInUser() {
        User user = userService.getLogInUser();
        return userDTOMapper.UserToUserDTO(user);
    }

    @GetMapping("/getLogInUserF")
    public UserFDTO getLogInUserF() {
        User user = userService.getLogInUser();
        return userDTOMapper.UserToUserFDTO(user);
    }

    @GetMapping("/getUserByUsername/{username}")
    public UserDTO getUserFDTOByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return userDTOMapper.UserToUserDTO(user);
    }


    @GetMapping("/getUserListByNoteId/{noteId}")
    public List<UserDTO> getUserListByNoteId(@PathVariable Long noteId) {
        List<User> userList = userService.getUserListByNoteId(noteId);
        return userDTOMapper.UserListToUserDTOList(userList);
    }

    @GetMapping("/getUserListByTagId/{tagId}")
    public List<UserDTO> getUserListByTagId(@PathVariable Long tagId) {
        List<User> userList = userService.getUserListByTagId(tagId);
        return userDTOMapper.UserListToUserDTOList(userList);
    }

    @GetMapping("/getUserListByRole/{userType}")
    @ApiOperation(value = "admin or standard")
    public List<UserDTO> getUserListByRole(@PathVariable String userType) {
        List<User> userList = userService.getUserListByRole(userType);
        return userDTOMapper.UserListToUserDTOList(userList);
    }


    //-- DeleteMapping

    @DeleteMapping("/deleteUserDTOByUserId/{userId}")
    public List<UserDTO> deleteUserDTOByUserId(@PathVariable Long userId) {
        List<User> userList = userService.deleteUserByUserId(userId);
        return userDTOMapper.UserListToUserDTOList(userList);
    }

    @DeleteMapping("/deleteRoleFromUser/")
    public UserDTO deleteRoleFromUser(@RequestParam Long userId, @RequestParam String userType) {
        User user = userService.deleteRoleFromUser(userId, userType);
        return userDTOMapper.UserToUserDTO(user);
    }

    @DeleteMapping("/deleteUserFromLogInUser/")
    public UserDTO deleteUserFromLogInUser(@RequestParam Long userId) {
        User user = userService.deleteUserFromLogInUserList(userId);
        return userDTOMapper.UserToUserDTO(user);
    }

    //--- Other


}
