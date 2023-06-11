package com.app.FO.repository.phoneNumber;

import com.app.FO.model.phoneNumber.PhoneNumberTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PhoneNumberTasksRepository extends JpaRepository<PhoneNumberTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber_tasks as tt where tt.phoneNumber_id=?1 and tt.tasks_id=?2")
    PhoneNumberTasks getPhoneNumberTasksByPhoneNumberIdAndTasksId(Long phoneNumberId, Long topicId);


}
