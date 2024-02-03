package com.app.FO.repository.dates;

import com.app.FO.model.dates.DatesTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DatesTasksRepository extends JpaRepository<DatesTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates_tasks as tt where tt.dates_id=?1 and tt.tasks_id=?2")
    DatesTasks getDatesTasksByDatesIdAndTasksId(Long datesId, Long topicId);


}
