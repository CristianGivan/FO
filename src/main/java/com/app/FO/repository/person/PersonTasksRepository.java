package com.app.FO.repository.person;

import com.app.FO.model.person.PersonTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonTasksRepository extends JpaRepository<PersonTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_tasks as tt where tt.person_id=?1 and tt.tasks_id=?2")
    PersonTasks getPersonTasksByPersonIdAndTasksId(Long personId, Long topicId);


}
