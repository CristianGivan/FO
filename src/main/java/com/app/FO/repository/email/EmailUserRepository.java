package com.app.FO.repository.email;

import com.app.FO.model.email.EmailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailUserRepository extends JpaRepository<EmailUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM email_user as tu where tu.email_id=?1 and tu.user_id=?2")
    EmailUser getEmailUserByEmailIdAndUserId(Long emailId, Long userId);


}
