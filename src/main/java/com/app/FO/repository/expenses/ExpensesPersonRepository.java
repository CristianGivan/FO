package com.app.FO.repository.expenses;

import com.app.FO.model.expenses.ExpensesPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesPersonRepository extends JpaRepository<ExpensesPerson, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses_person as tt where tt.expenses_id=?1 and tt.person_id=?2")
    ExpensesPerson getExpensesPersonByExpensesIdAndPersonId(Long expensesId, Long personId);


}
