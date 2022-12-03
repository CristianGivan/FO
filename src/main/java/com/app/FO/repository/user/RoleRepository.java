package com.app.FO.repository.user;


import com.app.FO.model.user.Role;
import com.app.FO.model.user.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleByRoleType(RoleType roleType);

}
