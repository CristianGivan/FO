package com.app.FO.service.security;


import com.app.FO.model.user.User;
import com.app.FO.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),
                buildSimpleGrantedAuthorities(user));
    }

    private List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(User user) {
        return user.getUserRoleList().stream().
                map(role -> new SimpleGrantedAuthority(
                        role.getRole().getRoleType().name())).collect(Collectors.toList());
    }


}
