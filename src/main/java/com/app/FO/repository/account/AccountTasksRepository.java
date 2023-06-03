package com.app.FO.repository.account;

import com.app.FO.model.account.AccountTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountTasksRepository extends JpaRepository<AccountTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM account_tasks as tt where tt.account_id=?1 and tt.tasks_id=?2")
    AccountTasks getAccountTasksByAccountIdAndTasksId(Long accountId, Long topicId);


}
