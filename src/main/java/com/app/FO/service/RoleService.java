package com.app.FO.service;


import com.app.FO.model.Role;
import com.app.FO.model.RoleType;
import com.app.FO.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
