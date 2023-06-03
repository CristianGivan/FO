package com.app.FO.repository.expense;

import com.app.FO.model.expense.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1")
    List<Expense> getExpenseListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and tu.expense_id=?2")
    Expense getExpenseFromUserIdByExpenseId(Long userId, Long expenseId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.subject=?2")
    Expense getExpenseFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Expense> getExpenseListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_topic as tn on t.expense_id = tn.expense_id inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Expense> getExpenseListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_tasks as tn on t.expense_id = tn.expense_id inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Expense> getExpenseListFromUserIdByTasksId(Long userId, Long tasksId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join (SELECT ti.expense_id FROM (SELECT t.expense_id FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1) as ti inner join expense_user tu on ti.expense_id = tu.expense_id where tu.user_id=?2)as tr on tr.expense_id=t.expense_id")
    List<Expense> getExpenseListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_tag as tt on t.expense_id = tt.expense_id inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Expense> getExpenseListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_reminder as tr on t.expense_id = tr.expense_id inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Expense> getExpenseListFromUserIdByReminderId(Long userId, Long reminderId);

}
