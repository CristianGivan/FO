package com.app.FO.repository.expense;

import com.app.FO.model.expense.ExpenseTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTagRepository extends JpaRepository<ExpenseTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expense_tag as tt where tt.expense_id=?1 and tt.tag_id=?2")
    ExpenseTag getExpenseTagByExpenseIdAndTagId(Long expenseId, Long tagId);


}
