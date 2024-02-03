package com.app.FO.repository.event;

import com.app.FO.model.event.EventTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EventTasksRepository extends JpaRepository<EventTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM event_tasks as tt where tt.event_id=?1 and tt.tasks_id=?2")
    EventTasks getEventTasksByEventIdAndTasksId(Long eventId, Long topicId);


}
