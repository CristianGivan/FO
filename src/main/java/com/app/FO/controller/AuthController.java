package com.app.FO.controller;


import com.app.FO.mapper.dto.user.AuthDTO;
import com.app.FO.mapper.dto.user.RegisterDTO;
import com.app.FO.model.user.User;
import com.app.FO.service.security.JwtTokenService;
import com.app.FO.service.security.UserDetailsServiceImpl;
import com.app.FO.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Autentificare")
public class AuthController {
    private JwtTokenService jwtTokenService;
    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsService;
    private UserService userService;

    @Autowired
    public AuthController(JwtTokenService jwtTokenService, AuthenticationManager authenticationManager,
                          UserDetailsServiceImpl userDetailsService, UserService userService) {
        this.jwtTokenService = jwtTokenService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    private String getToken(User user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        String token = jwtTokenService.generateToken(userDetails);
        System.out.println("Token: " + token);
        return token.toString();
    }

    private String getBearer(User user) {
        String string = "Bearer " + getToken(user);
        return string;
    }

    private String getBearerList(List<User> userList) {
        String string = userList.stream().map(user -> getBearer(user) + "\n").toString();
        return string;
    }


//Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMyIsImV4cCI6MTY4MTI2Mjk1N30.36c1ov50JQ2fC_PFs2owD_r34F9zVSuG685-_SFhpRFMtuLKIz_pGfIJ2hu_bWKADBanGoPBDsA9C_EGHrfokQ

    @PostMapping("/authenticateAll")
    @ApiOperation(value = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMyIsImV4cCI6MTY4MTA4OTA1MX0.p2e29XIuwXxRlYvFJZy84B20diA5nM3jmuty22MO6W9jUyOez7084mpGDFpz_ICY4V-p2piWIrr9OLCwxvC9JQ")
    public String authenticateAll(@RequestParam Long userId) {
        if (userId == 0) {
            return getBearerList(userService.getAllUser());

        } else {
            return getBearer(userService.getUserByUserId(userId));
        }
    }

    @PostMapping("/authenticate")
    @ApiOperation(value = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMyIsImV4cCI6MTY4MTA4OTA1MX0.p2e29XIuwXxRlYvFJZy84B20diA5nM3jmuty22MO6W9jUyOez7084mpGDFpz_ICY4V-p2piWIrr9OLCwxvC9JQ")
    public String authenticate(@RequestBody AuthDTO user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword()
        ));
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        return jwtTokenService.generateToken(userDetails);
    }

    //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMSIsImV4cCI6MTY5Njg4MTg3NX0.fBU-cMbgrvQMJeI2FQ4rbLQkVQBNX5OlycIJ04F8msQWsC-LfB7gq_UddQIIIy1K5DvgEg1uyOnw8OHYPGw0yA
    //Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMSIsImV4cCI6MTY5ODA2NzQxMn0.1wKwFIvSEFMBqzagt8k-Z3wpCJZAZMDd747S9Zm6XLJW24WkSJDsaL9CnA-1WObQmehX9KXSATRg2_jNbd7G5Q
    @PostMapping("/authenticateUser1")
    @ApiOperation(value = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMSIsImV4cCI6MTcxNzk3MTQ1MH0.pcRDh4-wVfvbN6TWIkU0M8c7BvSW6Lqxws8rOn1g-FuLpUl6E0yCx9jvuGSHODYrv6lbqY105FmJp4bA422DFw")
    public String authenticateUser1(@RequestParam String username, @RequestParam String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenService.generateToken(userDetails);
    }

    //Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMiIsImV4cCI6MTY5ODA2NjY5OH0.yDS-I7a1e-nPz7jgFtjJ6RcB_y_LisgcsojwmYpCq6RsT5X8APNQT5cZn6iYYN1W7kMQI5eJuZUtyEGlZ4z3Fg
    @PostMapping("/authenticateUser2")
    @ApiOperation(value = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMiIsImV4cCI6MTY5ODA2NjY5OH0.yDS-I7a1e-nPz7jgFtjJ6RcB_y_LisgcsojwmYpCq6RsT5X8APNQT5cZn6iYYN1W7kMQI5eJuZUtyEGlZ4z3Fg")
    public String authenticateUser2(@RequestParam String username, @RequestParam String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenService.generateToken(userDetails);
    }

    //Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMyIsImV4cCI6MTY5ODA2NzcyM30.zlrR5EoMBK77-1wnrvMsC6IgCQxLfwNLwP5jbV3Z4Y_5XgNhRp01T3EDD4lB45TXuOi_nKY57N4O8fLByaJOwg
    @PostMapping("/authenticateUser3")
    @ApiOperation(value =
            "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMyIsImV4cCI6MTY5ODA2NzcyM30.zlrR5EoMBK77-1wnrvMsC6IgCQxLfwNLwP5jbV3Z4Y_5XgNhRp01T3EDD4lB45TXuOi_nKY57N4O8fLByaJOwg"
    )
    public String authenticateUser3(@RequestParam String username, @RequestParam String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenService.generateToken(userDetails);
    }

    @PostMapping("/authenticateUser4")
    @ApiOperation(value = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyNCIsImV4cCI6MTY4NDUyODQ4M30.8LSwT7hVr2uMLXn6NMiBoJTjVFOTD52thu1SdmdD36_Yxj9HE9MEgwJJBfaIU8icwZ5Kfa7_RAeMSBcrvZeVuA")
    public String authenticateUser4(@RequestParam String username, @RequestParam String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenService.generateToken(userDetails);
    }

    @PostMapping("/authenticateUser5")
    @ApiOperation(value = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyNSIsImV4cCI6MTY4NDUyNzg4NH0.gP0jcNWj5gaWBq9rygBgWlXQsgoZX09nS755Z5gFRAgZlJw4T-RfZxFXLPMCgZIAnFMsqWZXEt-mhLeVWtIaUw")
    public String authenticateUser5(@RequestParam String username, @RequestParam String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenService.generateToken(userDetails);
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterDTO newUser) {
        return userService.postUser(newUser.getUsername(), newUser.getPassword(), newUser.getRole());
    }
}
