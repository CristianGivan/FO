package com.app.FO.repository.transaction;

import com.app.FO.model.transaction.TransactionTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionTasksRepository extends JpaRepository<TransactionTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction_tasks as tt where tt.transaction_id=?1 and tt.tasks_id=?2")
    TransactionTasks getTransactionTasksByTransactionIdAndTasksId(Long transactionId, Long topicId);


}
