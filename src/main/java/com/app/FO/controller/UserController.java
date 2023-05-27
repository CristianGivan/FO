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
        return userDTOMapper.userToUserFDTO(user);
    }

    //-- PutMapping

    @PutMapping("/putRoleToUser")
    public UserDTO putRoleToUser(@RequestParam Long userId, @RequestParam String userType) {
        User user = userService.putRoleToUser(userId, userType);
        return userDTOMapper.userToUserDTO(user);
    }

    @PutMapping("/putUsernameToUser")
    public UserDTO putUsernameToUser(@RequestParam Long userId, @RequestParam String username) {
        User user = userService.putUsernameToUser(userId, username);
        return userDTOMapper.userToUserDTO(user);
    }

    @PutMapping("/putPasswordToUser")
    public UserDTO putPasswordToUser(@RequestParam Long userId, @RequestParam String password) {
        User user = userService.putPasswordToUser(userId, password);
        return userDTOMapper.userToUserDTO(user);
    }

    @PutMapping("/putEmailToUser")
    public UserDTO putEmailToUser(@RequestParam Long userId, @RequestParam String email) {
        User user = userService.putEmailToUser(userId, email);
        return userDTOMapper.userToUserDTO(user);
    }

    @PutMapping("/putUserToLogInUser")
    public UserDTO putUserToLogInUser(@RequestParam Long userId) {
        User user = userService.putUserToLogInUser(userId);
        return userDTOMapper.userToUserDTO(user);
    }


    //-- GetMapping

    @GetMapping("/getAllUser")
    public List<UserDTO> getAllUser() {
        List<User> userList = userService.getAllUser();
        return userDTOMapper.userListToUserDTOList(userList);
    }

    @GetMapping("/getUserById/{userId}")
    public UserFDTO getUserById(@PathVariable Long userId) {
        User user = userService.getUserByUserId(userId);
        return userDTOMapper.userToUserFDTO(user);
    }

    @GetMapping("/getLogInUser")
    public UserDTO getLogInUser() {
        User user = userService.getLogInUser();
        return userDTOMapper.userToUserDTO(user);
    }

    @GetMapping("/getLogInUserF")
    public UserFDTO getLogInUserF() {
        User user = userService.getLogInUser();
        return userDTOMapper.userToUserFDTO(user);
    }

    @GetMapping("/getUserByUsername/{username}")
    public UserDTO getUserFDTOByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return userDTOMapper.userToUserDTO(user);
    }


    @GetMapping("/getUserListByNoteId/{noteId}")
    public List<UserDTO> getUserListByNoteId(@PathVariable Long noteId) {
        List<User> userList = userService.getUserListByNoteId(noteId);
        return userDTOMapper.userListToUserDTOList(userList);
    }

    @GetMapping("/getUserListByTagId/{tagId}")
    public List<UserDTO> getUserListByTagId(@PathVariable Long tagId) {
        List<User> userList = userService.getUserListByTagId(tagId);
        return userDTOMapper.userListToUserDTOList(userList);
    }

    @GetMapping("/getUserListByRole/{userType}")
    @ApiOperation(value = "admin or standard")
    public List<UserDTO> getUserListByRole(@PathVariable String userType) {
        List<User> userList = userService.getUserListByRole(userType);
        return userDTOMapper.userListToUserDTOList(userList);
    }

    @GetMapping("/getUserListByUser/{userId}")
    public List<UserFDTO> getUserListByUser(@PathVariable Long userId) {
        List<User> userList = userService.getUserListByUserId(userId);
        return userDTOMapper.userListToUserFDTOList(userList);
    }

    //-- DeleteMapping

    @DeleteMapping("/deleteUserByUserId/{userId}")
    public List<UserDTO> deleteUserByUserId(@PathVariable Long userId) {
        List<User> userList = userService.deleteUserByUserId(userId);
        return userDTOMapper.userListToUserDTOList(userList);
    }

    @DeleteMapping("/deleteRoleFromUser/")
    public UserDTO deleteRoleFromUser(@RequestParam Long userId, @RequestParam String userType) {
        User user = userService.deleteRoleFromUser(userId, userType);
        return userDTOMapper.userToUserDTO(user);
    }

    @DeleteMapping("/deleteUserFromLogInUser/")
    public UserFDTO deleteUserFromLogInUser(@RequestParam Long userId) {
        User user = userService.deleteUserFromLogInUserList(userId);
        return userDTOMapper.userToUserFDTO(user);
    }

    //--- Other


}
