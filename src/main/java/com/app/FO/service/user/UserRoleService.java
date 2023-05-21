package com.app.FO.service.user;

import com.app.FO.model.user.UserRole;
import com.app.FO.repository.user.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public void deleteUserRole(UserRole userRole) {
        userRoleRepository.delete(userRole);
    }

    public UserRole getUserRoleByUserRoleId(Long userRoleId) {
//        return userRoleRepository.getUserRoleByUserRoleId(userRoleId);
        return userRoleRepository.findById(userRoleId).orElse(null);
    }
}
