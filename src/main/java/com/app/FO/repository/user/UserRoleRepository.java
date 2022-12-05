package com.app.FO.repository.user;

import com.app.FO.model.user.Role;
import com.app.FO.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {


}
