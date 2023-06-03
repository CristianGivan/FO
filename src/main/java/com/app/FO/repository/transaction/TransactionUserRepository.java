package com.app.FO.repository.transaction;

import com.app.FO.model.transaction.TransactionUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionUserRepository extends JpaRepository<TransactionUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction_user as tu where tu.transaction_id=?1 and tu.user_id=?2")
    TransactionUser getTransactionUserByTransactionIdAndUserId(Long transactionId, Long userId);


}
