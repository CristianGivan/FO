package com.app.FO.repository.event;

import com.app.FO.model.event.EventTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTagRepository extends JpaRepository<EventTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM event_tag as tt where tt.event_id=?1 and tt.tag_id=?2")
    EventTag getEventTagByEventIdAndTagId(Long eventId, Long tagId);


}
