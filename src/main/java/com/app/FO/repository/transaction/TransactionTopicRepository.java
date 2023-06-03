package com.app.FO.repository.transaction;

import com.app.FO.model.transaction.TransactionTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTopicRepository extends JpaRepository<TransactionTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM transaction_topic as tt where tt.transaction_id=?1 and tt.topic_id=?2")
    TransactionTopic getTransactionTopicByTransactionIdAndTopicId(Long transactionId, Long topicId);


}
