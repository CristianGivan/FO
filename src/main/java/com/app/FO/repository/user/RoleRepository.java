package com.app.FO.repository.user;


import com.app.FO.model.user.Role;
import com.app.FO.model.user.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleByRoleType(RoleType roleType);
    @Query("select r from Role r inner join UserRole ur on r.id=ur.role.id " +
            "where ur.user.id=?1")
    List<Role> findRolesByUserId(Long userId);

}
