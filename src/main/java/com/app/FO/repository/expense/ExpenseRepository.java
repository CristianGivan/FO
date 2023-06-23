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
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.name=?2")
    Expense getExpenseFromUserIdByName(Long userId, String name);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=:userId and t.name like %:containingText%")
    List<Expense> getExpenseListByNameContains(@Param("userId") Long UserId, @Param("containingText") String nameText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.producer=?2")
    Expense getExpenseFromUserIdByProducer(Long userId, String producer);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=:userId and t.producer like %:containingText%")
    List<Expense> getExpenseListByProducerContains(@Param("userId") Long UserId, @Param("containingText") String producerText);

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
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.number_buys=?2")
    Expense getExpenseFromUserIdByNumberOfBuys(Long userId, Integer numberOfBuys);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=?1 and t.number_buys between ?2 and ?3")
    List<Expense> getExpenseListFromUserIdByNumberOfBuysBetween(Long UserId, Integer numberOfBuysMin, Integer numberOfBuysMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.number_mean=?2")
    Expense getExpenseFromUserIdByNumberForMean(Long userId, Integer numberForMean);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=?1 and t.number_mean between ?2 and ?3")
    List<Expense> getExpenseListFromUserIdByNumberForMeanBetween(Long UserId, Integer numberForMeanMin, Integer numberForMeanMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.mean_quantity=?2")
    Expense getExpenseFromUserIdByMeanQuantity(Long userId, Double meanQuantity);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=?1 and t.mean_quantity between ?2 and ?3")
    List<Expense> getExpenseListFromUserIdByMeanQuantityBetween(Long UserId, Double meanQuantityMin, Double meanQuantityMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user tu on t.expense_id = tu.expense_id where tu.user_id=?1 and t.mean_unit_price=?2")
    Expense getExpenseFromUserIdByMeanUnitPrice(Long userId, Double meanUnitPrice);

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense as t inner join expense_user ut on t.expense_id = ut.expense_id where ut.user_id=?1 and t.mean_unit_price between ?2 and ?3")
    List<Expense> getExpenseListFromUserIdByMeanUnitPriceBetween(Long UserId, Double meanUnitPriceMin, Double meanUnitPriceMax);

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
