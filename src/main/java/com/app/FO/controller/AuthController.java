package com.app.FO.controller;


import com.app.FO.dto.user.AuthDTO;
import com.app.FO.dto.user.RegisterDTO;
import com.app.FO.model.user.User;
import com.app.FO.service.security.JwtTokenService;
import com.app.FO.service.security.UserDetailsServiceImpl;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
        this.userService=userService;
    }

//Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMyIsImV4cCI6MTY4MTI2Mjk1N30.36c1ov50JQ2fC_PFs2owD_r34F9zVSuG685-_SFhpRFMtuLKIz_pGfIJ2hu_bWKADBanGoPBDsA9C_EGHrfokQ

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthDTO user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword()
        ));
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        return jwtTokenService.generateToken(userDetails);
    }
    @PostMapping("/register")
    public User register(@RequestBody RegisterDTO newUser){
        return userService.registerStandardUser(newUser);
    }
}
