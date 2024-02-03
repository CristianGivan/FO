package com.app.FO.repository.user;

import com.app.FO.model.user.UserUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserUserRepository extends JpaRepository<UserUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM user_user as uu where uu.user_id=?1 and uu.user_linked_id=?2")
    UserUser getUserUserByUserIdAndUserId(Long userId, Long userIdLinked);

}
