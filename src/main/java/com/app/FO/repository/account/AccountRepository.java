package com.app.FO.repository.account;

import com.app.FO.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1")
    List<Account> getAccountListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1 and tu.account_id=?2")
    Account getAccountFromUserIdByAccountId(Long userId, Long accountId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1 and t.subject=?2")
    Account getAccountFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_user ut on t.account_id = ut.account_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Account> getAccountListFromUserIdBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String subjectText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1 and t.type=?2")
    Account getAccountFromUserIdByType(Long userId, String type);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_user ut on t.account_id = ut.account_id where ut.user_id=:userId and t.type like %:containingText%")
    List<Account> getAccountListFromUserIdByTypeContains(@Param("userId") Long UserId, @Param("containingText") String typeText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1 and t.balance=?2")
    Account getAccountFromUserIdByBalance(Long userId, Double balance);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_user ut on t.account_id = ut.account_id where ut.user_id=?1 and t.balance between ?2 and ?3")
    List<Account> getAccountListFromUserIdByBalanceBetween(Long UserId, Double balanceMin, Double balanceMax);


    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1 and t.created_date=?2")
    Account getAccountFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_user ut on t.account_id = ut.account_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Account> getAccountListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join (SELECT ti.account_id FROM (SELECT t.account_id FROM account as t inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1) as ti inner join account_user tu on ti.account_id = tu.account_id where tu.user_id=?2)as tr on tr.account_id=t.account_id")
    List<Account> getAccountListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_tag as tt on t.account_id = tt.account_id inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Account> getAccountListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_reminder as tr on t.account_id = tr.account_id inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Account> getAccountListFromUserIdByReminderId(Long userId, Long reminderId);


    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_topic as tn on t.account_id = tn.account_id inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Account> getAccountListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_tasks as tn on t.account_id = tn.account_id inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Account> getAccountListFromUserIdByTasksId(Long userId, Long tasksId);


    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_expenses as tn on t.account_id = tn.account_id inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1 and tn.expenses_id=?2")
    List<Account> getAccountListFromUserIdByExpensesId(Long userId, Long expensesId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM account as t inner join account_transaction as tn on t.account_id = tn.account_id inner join account_user tu on t.account_id = tu.account_id where tu.user_id=?1 and tn.transaction_id=?2")
    List<Account> getAccountListFromUserIdByTransactionId(Long userId, Long transactionId);
}
