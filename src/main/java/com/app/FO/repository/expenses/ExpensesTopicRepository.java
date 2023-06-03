package com.app.FO.repository.expenses;

import com.app.FO.model.expenses.ExpensesTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesTopicRepository extends JpaRepository<ExpensesTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses_topic as tt where tt.expenses_id=?1 and tt.topic_id=?2")
    ExpensesTopic getExpensesTopicByExpensesIdAndTopicId(Long expensesId, Long topicId);


}
