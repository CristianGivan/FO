package com.app.FO.repository.expenses;

import com.app.FO.model.expenses.ExpensesTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesTagRepository extends JpaRepository<ExpensesTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses_tag as tt where tt.expenses_id=?1 and tt.tag_id=?2")
    ExpensesTag getExpensesTagByExpensesIdAndTagId(Long expensesId, Long tagId);


}
