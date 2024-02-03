package com.app.FO.repository.event;

import com.app.FO.model.event.EventPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventPersonRepository extends JpaRepository<EventPerson, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM event_person as tt where tt.event_id=?1 and tt.person_id=?2")
    EventPerson getEventPersonByEventIdAndPersonId(Long eventId, Long personId);


}
