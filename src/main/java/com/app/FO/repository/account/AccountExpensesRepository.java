package com.app.FO.repository.account;

import com.app.FO.model.account.AccountExpenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountExpensesRepository extends JpaRepository<AccountExpenses, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM account_expenses as tt where tt.account_id=?1 and tt.expenses_id=?2")
    AccountExpenses getAccountExpensesByAccountIdAndExpensesId(Long accountId, Long expensesId);


}
