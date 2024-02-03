package com.app.FO.repository.event;

import com.app.FO.model.event.EventUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventUserRepository extends JpaRepository<EventUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM event_user as tu where tu.event_id=?1 and tu.user_id=?2")
    EventUser getEventUserByEventIdAndUserId(Long eventId, Long userId);


}
