package com.app.FO.controller;


import com.app.FO.dto.user.AuthDTO;
import com.app.FO.dto.user.RegisterDTO;
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
import org.springframework.web.bind.annotation.RestController;

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

//Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMyIsImV4cCI6MTY4MTI2Mjk1N30.36c1ov50JQ2fC_PFs2owD_r34F9zVSuG685-_SFhpRFMtuLKIz_pGfIJ2hu_bWKADBanGoPBDsA9C_EGHrfokQ

    @PostMapping("/authenticate")
    @ApiOperation(value = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMyIsImV4cCI6MTY4MTA4OTA1MX0.p2e29XIuwXxRlYvFJZy84B20diA5nM3jmuty22MO6W9jUyOez7084mpGDFpz_ICY4V-p2piWIrr9OLCwxvC9JQ")
    public String authenticate(@RequestBody AuthDTO user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword()
        ));
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        return jwtTokenService.generateToken(userDetails);
    }
    @PostMapping("/authenticateUser1")
    @ApiOperation(value = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMSIsImV4cCI6MTY4NDUyNjgwNn0.G32GHNQ3ly1jJuje7mT0DEoMNVx8Nv0STqs2-IPYAHjUDb9ebl_53HV0JvLICLtoM9iIuAYvFA3ciImrNXja9g")
    public String authenticateUser1(@RequestBody String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenService.generateToken(userDetails);
    }
    @PostMapping("/authenticateUser2")
    @ApiOperation(value = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMiIsImV4cCI6MTY4NDUyNzUwN30.485xc7qF22Waz8HCWXqxs7WY0GFNBjGE0VT_p3One649pMq__ozIbP-et47pjLvco0tovz2OO6yTuO_qUKd-FA")
    public String authenticateUser2(@RequestBody String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenService.generateToken(userDetails);
    }
    @PostMapping("/authenticateUser3")
    @ApiOperation(value = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVc2VyMyIsImV4cCI6MTY4NDUyNzc1M30.sTJUcJZ047Kgr4sdZaVbu8w-OCArFtgqOsQR7c7cRaie0kW-DNf2Bgxxr0h3ar1LhqrXgpNK4usTFYasmfivZA")
    public String authenticateUser3(@RequestBody String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenService.generateToken(userDetails);
    }

    @PostMapping("/authenticateUser4")
    @ApiOperation(value = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyNCIsImV4cCI6MTY4NDUyODQ4M30.8LSwT7hVr2uMLXn6NMiBoJTjVFOTD52thu1SdmdD36_Yxj9HE9MEgwJJBfaIU8icwZ5Kfa7_RAeMSBcrvZeVuA")
    public String authenticateUser4(@RequestBody String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenService.generateToken(userDetails);
    }
    @PostMapping("/authenticateUser5")
    @ApiOperation(value = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyNSIsImV4cCI6MTY4NDUyNzg4NH0.gP0jcNWj5gaWBq9rygBgWlXQsgoZX09nS755Z5gFRAgZlJw4T-RfZxFXLPMCgZIAnFMsqWZXEt-mhLeVWtIaUw")
    public String authenticateUser5(@RequestBody String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return jwtTokenService.generateToken(userDetails);
    }
    @PostMapping("/register")
    public User register(@RequestBody RegisterDTO newUser) {
        return userService.registerStandardUser(newUser);
    }
}
