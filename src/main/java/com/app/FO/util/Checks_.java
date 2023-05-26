package com.app.FO.util;

import com.app.FO.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Checks_ {
    private UserRepository userRepository;
    private ServiceAll serviceAll;

    @Autowired
    public Checks_(UserRepository userRepository, ServiceAll serviceAll) {
        this.userRepository = userRepository;
        this.serviceAll = serviceAll;

    }

}
