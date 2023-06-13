package com.app.FO.repository.theDay;

import com.app.FO.model.theDay.TheDayTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TheDayTasksRepository extends JpaRepository<TheDayTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM theDay_tasks as tt where tt.theDay_id=?1 and tt.tasks_id=?2")
    TheDayTasks getTheDayTasksByTheDayIdAndTasksId(Long theDayId, Long topicId);


}
