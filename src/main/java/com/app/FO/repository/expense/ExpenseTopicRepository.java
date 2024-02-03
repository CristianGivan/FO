package com.app.FO.repository.expense;

import com.app.FO.model.expense.ExpenseTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTopicRepository extends JpaRepository<ExpenseTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense_topic as tt where tt.expense_id=?1 and tt.topic_id=?2")
    ExpenseTopic getExpenseTopicByExpenseIdAndTopicId(Long expenseId, Long topicId);


}
