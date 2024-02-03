package com.app.FO.repository.expenses;

import com.app.FO.model.expenses.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {


    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1")
    List<Expenses> getExpensesListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and tu.expenses_id=?2")
    Expenses getExpensesFromUserIdByExpensesId(Long userId, Long expensesId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and t.subject=?2")
    Expenses getExpensesFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user ut on t.expenses_id = ut.expenses_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Expenses> getExpensesListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and t.type=?2")
    Expenses getExpensesFromUserIdByType(Long userId, String type);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user ut on t.expenses_id = ut.expenses_id where ut.user_id=:userId and t.type like %:containingText%")
    List<Expenses> getExpensesListByTypeContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and t.shop=?2")
    Expenses getExpensesFromUserIdByShop(Long userId, String shop);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user ut on t.expenses_id = ut.expenses_id where ut.user_id=:userId and t.shop like %:containingText%")
    List<Expenses> getExpensesListFromUserIdByShopContains(@Param("userId") Long UserId, @Param("containingText") String tagText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and t.checked_price=?2")
    Expenses getExpensesFromUserIdByCheckedPrice(Long userId, Double checkedPrice);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user ut on t.expenses_id = ut.expenses_id where ut.user_id=?1 and t.checked_price between ?2 and ?3")
    List<Expenses> getExpensesListFromUserIdByCheckedPriceBetween(Long UserId, Double checkedPriceMin, Double checkedPriceMax);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and t.total_price=?2")
    Expenses getExpensesFromUserIdByTotalPrice(Long userId, Double totalPrice);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user ut on t.expenses_id = ut.expenses_id where ut.user_id=?1 and t.total_price between ?2 and ?3")
    List<Expenses> getExpensesListFromUserIdByTotalPriceBetween(Long UserId, Double totalPriceMin, Double totalPriceMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and t.payed_date=?2")
    Expenses getExpensesFromUserIdByPayedDate(Long userId, LocalDateTime payedDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user ut on t.expenses_id = ut.expenses_id where ut.user_id=?1 and t.payed_date between ?2 and ?3")
    List<Expenses> getExpensesListFromUserIdByPayedDateBetween(Long UserId, LocalDateTime payedDateMin, LocalDateTime payedDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and t.created_date=?2")
    Expenses getExpensesFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_user ut on t.expenses_id = ut.expenses_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Expenses> getExpensesListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join (SELECT ti.expenses_id FROM (SELECT t.expenses_id FROM expenses as t inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1) as ti inner join expenses_user tu on ti.expenses_id = tu.expenses_id where tu.user_id=?2)as tr on tr.expenses_id=t.expenses_id")
    List<Expenses> getExpensesListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_tag as tt on t.expenses_id = tt.expenses_id inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Expenses> getExpensesListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_reminder as tr on t.expenses_id = tr.expenses_id inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Expenses> getExpensesListFromUserIdByReminderId(Long userId, Long reminderId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_topic as tn on t.expenses_id = tn.expenses_id inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Expenses> getExpensesListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_tasks as tn on t.expenses_id = tn.expenses_id inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Expenses> getExpensesListFromUserIdByTasksId(Long userId, Long tasksId);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_expense as tn on t.expenses_id = tn.expenses_id inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and tn.expense_id=?2")
    List<Expenses> getExpensesListFromUserIdByExpenseId(Long userId, Long expenseId);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join account_expenses as tn on t.expenses_id = tn.expenses_id inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and tn.account_id=?2")
    List<Expenses> getExpensesListFromUserIdByAccountId(Long userId, Long accountId);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses as t inner join expenses_person as tn on t.expenses_id = tn.expenses_id inner join expenses_user tu on t.expenses_id = tu.expenses_id where tu.user_id=?1 and tn.person_id=?2")
    List<Expenses> getExpensesListFromUserIdByPayerId(Long userId, Long payerId);

}
