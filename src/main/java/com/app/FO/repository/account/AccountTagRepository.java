package com.app.FO.repository.account;

import com.app.FO.model.account.AccountTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTagRepository extends JpaRepository<AccountTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM account_tag as tt where tt.account_id=?1 and tt.tag_id=?2")
    AccountTag getAccountTagByAccountIdAndTagId(Long accountId, Long tagId);


}
