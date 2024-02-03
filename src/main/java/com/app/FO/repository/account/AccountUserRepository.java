package com.app.FO.repository.account;

import com.app.FO.model.account.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM account_user as tu where tu.account_id=?1 and tu.user_id=?2")
    AccountUser getAccountUserByAccountIdAndUserId(Long accountId, Long userId);


}
