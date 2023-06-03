package com.app.FO.repository.transaction;

import com.app.FO.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction as t inner join transaction_user tu on t.transaction_id = tu.transaction_id where tu.user_id=?1")
    List<Transaction> getTransactionListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction as t inner join transaction_user tu on t.transaction_id = tu.transaction_id where tu.user_id=?1 and tu.transaction_id=?2")
    Transaction getTransactionFromUserIdByTransactionId(Long userId, Long transactionId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction as t inner join transaction_user tu on t.transaction_id = tu.transaction_id where tu.user_id=?1 and t.subject=?2")
    Transaction getTransactionFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction as t inner join transaction_user ut on t.transaction_id = ut.transaction_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Transaction> getTransactionListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction as t inner join transaction_topic as tn on t.transaction_id = tn.transaction_id inner join transaction_user tu on t.transaction_id = tu.transaction_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Transaction> getTransactionListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction as t inner join transaction_tasks as tn on t.transaction_id = tn.transaction_id inner join transaction_user tu on t.transaction_id = tu.transaction_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Transaction> getTransactionListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction as t inner join (SELECT ti.transaction_id FROM (SELECT t.transaction_id FROM transaction as t inner join transaction_user tu on t.transaction_id = tu.transaction_id where tu.user_id=?1) as ti inner join transaction_user tu on ti.transaction_id = tu.transaction_id where tu.user_id=?2)as tr on tr.transaction_id=t.transaction_id")
    List<Transaction> getTransactionListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction as t inner join transaction_tag as tt on t.transaction_id = tt.transaction_id inner join transaction_user tu on t.transaction_id = tu.transaction_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Transaction> getTransactionListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction as t inner join transaction_reminder as tr on t.transaction_id = tr.transaction_id inner join transaction_user tu on t.transaction_id = tu.transaction_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Transaction> getTransactionListFromUserIdByReminderId(Long userId, Long reminderId);

}
