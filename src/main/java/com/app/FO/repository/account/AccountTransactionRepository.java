package com.app.FO.repository.account;

import com.app.FO.model.account.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM account_transaction as tt where tt.account_id=?1 and tt.transaction_id=?2")
    AccountTransaction getAccountTransactionByAccountIdAndTransactionId(Long accountId, Long transactionId);


}
