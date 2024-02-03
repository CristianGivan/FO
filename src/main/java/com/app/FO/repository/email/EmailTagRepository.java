package com.app.FO.repository.email;

import com.app.FO.model.email.EmailTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTagRepository extends JpaRepository<EmailTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM email_tag as tt where tt.email_id=?1 and tt.tag_id=?2")
    EmailTag getEmailTagByEmailIdAndTagId(Long emailId, Long tagId);


}
