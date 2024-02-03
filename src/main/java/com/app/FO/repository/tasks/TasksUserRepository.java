package com.app.FO.repository.tasks;

import com.app.FO.model.tasks.TasksUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksUserRepository extends JpaRepository<TasksUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM tasks_user as tu where tu.tasks_id=?1 and tu.user_id=?2")
    TasksUser getTasksUserByTasksIdAndUserId(Long tasksId, Long userId);


}
