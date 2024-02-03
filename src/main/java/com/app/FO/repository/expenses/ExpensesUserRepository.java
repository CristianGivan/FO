package com.app.FO.repository.expenses;

import com.app.FO.model.expenses.ExpensesUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesUserRepository extends JpaRepository<ExpensesUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses_user as tu where tu.expenses_id=?1 and tu.user_id=?2")
    ExpensesUser getExpensesUserByExpensesIdAndUserId(Long expensesId, Long userId);


}
