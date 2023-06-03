package com.app.FO.repository.account;

import com.app.FO.model.account.AccountTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTopicRepository extends JpaRepository<AccountTopic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM account_topic as tt where tt.account_id=?1 and tt.topic_id=?2")
    AccountTopic getAccountTopicByAccountIdAndTopicId(Long accountId, Long topicId);


}
