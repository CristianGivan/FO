package com.app.FO.service.user;

import com.app.FO.model.user.UserUser;
import com.app.FO.repository.user.UserUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUserService {
    private UserUserRepository userUserRepository;

    @Autowired
    public UserUserService(UserUserRepository userUserRepository) {
        this.userUserRepository = userUserRepository;
    }

    public UserUser getUserUserByUserUserId(Long userId, Long userIdLinked) {
        return userUserRepository.getUserUserByUserIdAndUserId(userId, userIdLinked);
    }
}
