package com.app.FO.controller;


import com.app.FO.mapper.dto.user.RegisterDTO;
import com.app.FO.mapper.dto.user.UserDTO;
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
    public UserDTO postUser(@RequestBody RegisterDTO newUser) {
        User user = userService.postUser(newUser.getUsername(), newUser.getPassword(), newUser.getRole());
        return userDTOMapper.userToUserDTO(user);
    }

    //-- PutMapping


    @PutMapping("/putUsernameToLogInUser")
    public UserDTO putUsernameToLogInUser(@RequestParam String username) {
        User user = userService.putUsernameToLogInUser(username);
        return userDTOMapper.userToUserDTO(user);
    }

    @PutMapping("/putPasswordToLogInUser")
    public UserDTO putPasswordToLogInUser(@RequestParam String password) {
        User user = userService.putPasswordToLogInUser(password);
        return userDTOMapper.userToUserDTO(user);

    }

    @PutMapping("/putEmailToLogInUser")
    public UserDTO putEmailToLogInUser(@RequestParam Long emailId) {
        User user = userService.putEmailToLogInUser(emailId);
        return userDTOMapper.userToUserDTO(user);
    }

    @PutMapping("/putUserToLogInUser")
    public UserDTO putUserToLogInUser(@RequestParam Long userId) {
        User user = userService.putUserToLogInUser(userId);
        return userDTOMapper.userToUserDTO(user);
    }

    @PutMapping("/putRoleToUser")
    public UserDTO putRoleToUser(@RequestParam Long userId, @RequestParam String userType) {
        User user = userService.putRoleToUser(userId, userType);
        return userDTOMapper.userToUserDTO(user);
    }

    //-- DeleteMapping

    @DeleteMapping("/deleteUserFromLogInUser/")
    public UserDTO deleteUserFromLogInUser(@RequestParam Long userId) {
        User user = userService.deleteUserFromLogInUser(userId);
        return userDTOMapper.userToUserDTO(user);
    }

    @DeleteMapping("/deleteRoleFromUser/")
    public UserDTO deleteRoleFromUser(@RequestParam Long userId, @RequestParam String userType) {
        User user = userService.deleteRoleFromUser(userId, userType);
        return userDTOMapper.userToUserDTO(user);
    }

    @DeleteMapping("/deleteUserByUserId/")
    public List<UserDTO> deleteUserByUserId(@RequestParam Long userId) {
        List<User> userList = userService.deleteUserByUserId(userId);
        return userDTOMapper.userListToUserDTOList(userList);
    }

    //-- GetMapping

    @GetMapping("/getAllUser")
    public List<UserDTO> getAllUser() {
        List<User> userList = userService.getAllUser();
        return userDTOMapper.userListToUserDTOList(userList);
    }

    @GetMapping("/getLogInUser")
    public UserDTO getLogInUser() {
        User user = userService.getLogInUser();
        return userDTOMapper.userToUserDTO(user);
    }

    @GetMapping("/getLogInUserF")
    public UserDTO getLogInUserF() {
        User user = userService.getLogInUser();
        return userDTOMapper.userToUserDTO(user);
    }

    @GetMapping("/getUserById/")
    public UserDTO getUserById(@RequestParam Long userId) {
        User user = userService.getUserByUserId(userId);
        return userDTOMapper.userToUserDTO(user);
    }


    @GetMapping("/getUserListByUsername")
    public List<UserDTO> getUserListByUsername(@RequestParam String username) {
        List<User> userList = userService.getUserListByUsername(username);
        return userDTOMapper.userListToUserDTOList(userList);
    }

    @GetMapping("/getUserListByUsernameContains")
    public List<UserDTO> getUserListByUsernameContains(@RequestParam String usernameContain) {
        List<User> userList = userService.getUserListByUsernameContains(usernameContain);
        return userDTOMapper.userListToUserDTOList(userList);
    }

    @GetMapping("/getUserByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public UserDTO getUserByCreatedDate(@RequestParam String createdDate) {
        User user = userService.getUserByCreatedDate(createdDate);
        return userDTOMapper.userToUserDTO(user);
    }

    @GetMapping("/getUserListByCreatedDateBetween")
    public List<UserDTO> getUserListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<User> userList = userService.getUserListByCreatedDateBetween(createdDateMin, createdDateMax);
        return userDTOMapper.userListToUserDTOList(userList);
    }


    @GetMapping("/getUserListByUser/")
    public List<UserDTO> getUserListByUser(@RequestParam Long userId) {
        List<User> userList = userService.getUserListByUserId(userId);
        return userDTOMapper.userListToUserDTOList(userList);
    }

    @GetMapping("/getUserListByEmail/")
    public List<UserDTO> getUserListByEmail(@RequestParam Long emailId) {
        List<User> userList = userService.getUserListByEmail(emailId);
        return userDTOMapper.userListToUserDTOList(userList);
    }

    @GetMapping("/getUserListByRole/")
    @ApiOperation(value = "admin or standard")
    public List<UserDTO> getUserListByRole(@RequestParam String userType) {
        List<User> userList = userService.getUserListByRole(userType);
        return userDTOMapper.userListToUserDTOList(userList);
    }
    //--- Other


}
