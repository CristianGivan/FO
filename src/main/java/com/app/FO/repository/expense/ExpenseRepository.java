package com.app.FO.repository.expense;

import com.app.FO.model.expense.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and tu.expenses_id=?2 and tu.product_id=?3")
    Expense getExpenseFromUserIdByExpensesIdProductId(Long userId, Long expenseId, Long productId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.checked=?2")
    List<Expense> getExpenseListFromUserIdByChecked(Long userId, Boolean checked);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.subject=?2")
    Expense getExpenseFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Expense> getExpenseListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String subjectText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.category=?2")
    Expense getExpenseFromUserIdByCategory(Long userId, String category);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=:userId and t.category like %:containingText%")
    List<Expense> getExpenseListByCategoryContains(@Param("userId") Long UserId, @Param("containingText") String categoryText);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.quantity=?2")
    Expense getExpenseFromUserIdByQuantity(Long userId, Double quantity);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=?1 and t.quantity between ?2 and ?3")
    List<Expense> getExpenseListFromUserIdByQuantityBetween(Long userId, Double quantityMin, Double quantityMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.unit_price=?2")
    Expense getExpenseFromUserIdByUnitPrice(Long userId, Double unitPrice);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=?1 and t.unit_price between ?2 and ?3")
    List<Expense> getExpenseListFromUserIdByUnitPriceBetween(Long userId, Double unitPriceMin, Double unitPriceMax);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.total_price=?2")
    Expense getExpenseFromUserIdByTotalPrice(Long userId, Double totalPrice);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=?1 and t.total_price between ?2 and ?3")
    List<Expense> getExpenseListFromUserIdByTotalPriceBetween(Long userId, Double totalPriceMin, Double totalPriceMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.estimated_total_price=?2")
    Expense getExpenseFromUserIdByEstimatedTotalPrice(Long userId, Double estimatedTotalPrice);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=?1 and t.estimated_total_price between ?2 and ?3")
    List<Expense> getExpenseListFromUserIdByEstimatedTotalPriceBetween(Long UserId, Double estimatedTotalPriceMin, Double estimatedTotalPriceMax);


    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.checked_date=?2")
    Expense getExpenseFromUserIdByCheckedDate(Long userId, LocalDateTime checkedDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=?1 and t.checked_date between ?2 and ?3")
    List<Expense> getExpenseListFromUserIdByCheckedDateBetween(Long UserId, LocalDateTime checkedDateMin, LocalDateTime checkedDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.created_date=?2")
    Expense getExpenseFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Expense> getExpenseListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join (SELECT ti.expense_id FROM (SELECT t.expense_id FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1) as ti inner join expense_user tu on ti.expense_id = tu.expense_id where tu.user_id=?2)as tr on tr.expense_id=t.expense_id")
    List<Expense> getExpenseListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_tag as tt on t.expense_id = tt.expense_id inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Expense> getExpenseListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_reminder as tr on t.expense_id = tr.expense_id inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Expense> getExpenseListFromUserIdByReminderId(Long userId, Long reminderId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_topic as tn on t.expense_id = tn.expense_id inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and tn.topic_id=?2")
    List<Expense> getExpenseListFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_tasks as tn on t.expense_id = tn.expense_id inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and tn.tasks_id=?2")
    List<Expense> getExpenseListFromUserIdByTasksId(Long userId, Long tasksId);

}
