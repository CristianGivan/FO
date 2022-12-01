package com.app.FO.repository;


import com.app.FO.model.Role;
import com.app.FO.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleByRoleType(RoleType roleType);

}
