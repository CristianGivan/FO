package com.app.FO.repository.dates;

import com.app.FO.model.dates.DatesUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DatesUserRepository extends JpaRepository<DatesUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates_user as tu where tu.dates_id=?1 and tu.user_id=?2")
    DatesUser getDatesUserByDatesIdAndUserId(Long datesId, Long userId);


}
