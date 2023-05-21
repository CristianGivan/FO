package com.app.FO.repository.user;

import com.app.FO.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

//    @Query(nativeQuery = true, value =
//            "SELECT * FROM user_role as ur where ur.user_role_id=?1")
//    UserRole getUserRoleByUserRoleId(Long userRoleId);

}
