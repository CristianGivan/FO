package com.app.FO.repository.snooze;

import com.app.FO.model.snooze.SnoozeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SnoozeUserRepository extends JpaRepository<SnoozeUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM snooze_user as tu where tu.snooze_id=?1 and tu.user_id=?2")
    SnoozeUser getSnoozeUserBySnoozeIdAndUserId(Long snoozeId, Long userId);


}
