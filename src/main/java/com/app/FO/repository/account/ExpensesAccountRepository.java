package com.app.FO.repository.account;

import com.app.FO.model.account.ExpensesAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesAccountRepository extends JpaRepository<ExpensesAccount, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM expenses_account as tt where  tt.expenses_id=?1 and tt.account_id=?2")
    ExpensesAccount getExpensesAccountByAccountIdAndExpensesId(Long expensesId, Long accountId);


}
