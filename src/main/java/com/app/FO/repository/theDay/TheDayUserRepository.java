package com.app.FO.repository.theDay;

import com.app.FO.model.theDay.TheDayUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TheDayUserRepository extends JpaRepository<TheDayUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM theDay_user as tu where tu.theDay_id=?1 and tu.user_id=?2")
    TheDayUser getTheDayUserByTheDayIdAndUserId(Long theDayId, Long userId);


}
