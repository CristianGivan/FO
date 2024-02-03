package com.app.FO.repository.task;

import com.app.FO.model.task.TaskUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskUserRepository extends JpaRepository<TaskUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM task_user as tu where tu.task_id=?1 and tu.user_id=?2")
    TaskUser getTaskUserByTaskIdAndUserId(Long taskId, Long userId);


}
