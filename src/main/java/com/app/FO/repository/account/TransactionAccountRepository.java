package com.app.FO.repository.account;

import com.app.FO.model.account.TransactionAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionAccountRepository extends JpaRepository<TransactionAccount, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction_account as tt where tt.transaction_id=?1 and  tt.account_id=?2")
    TransactionAccount getTransactionAccountByAccountIdAndTransactionId(Long transactionId, Long accountId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction_account as tt where tt.direction=?1 and tt.transaction_id=?2")
    TransactionAccount getTransactionAccountByDirectionAndTransactionId(String direction, Long transactionId);

}
