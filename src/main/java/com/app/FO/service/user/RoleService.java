package com.app.FO.service.user;


import com.app.FO.model.user.Role;
import com.app.FO.model.user.RoleType;
import com.app.FO.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleByType(RoleType roleType){
        return roleRepository.findRoleByRoleType(roleType);
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public List<Role> findRolesByUserId(Long userId){
        return roleRepository.findRolesByUserId(userId);
    }
    public List<String> getAllRolesByUserIdAsStrings(Long userId){
        return roleRepository.findRolesByUserId(userId).stream()
                .map(role -> role.getRoleType().toString())
                .toList();
    }
}
