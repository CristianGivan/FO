package com.app.FO.repository.transaction;

import com.app.FO.model.transaction.TransactionTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTagRepository extends JpaRepository<TransactionTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction_tag as tt where tt.transaction_id=?1 and tt.tag_id=?2")
    TransactionTag getTransactionTagByTransactionIdAndTagId(Long transactionId, Long tagId);


}
