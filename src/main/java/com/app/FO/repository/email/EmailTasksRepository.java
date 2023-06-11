package com.app.FO.repository.email;

import com.app.FO.model.email.EmailTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmailTasksRepository extends JpaRepository<EmailTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM email_tasks as tt where tt.email_id=?1 and tt.tasks_id=?2")
    EmailTasks getEmailTasksByEmailIdAndTasksId(Long emailId, Long topicId);


}
