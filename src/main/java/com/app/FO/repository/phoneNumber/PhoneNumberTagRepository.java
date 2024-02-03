package com.app.FO.repository.phoneNumber;

import com.app.FO.model.phoneNumber.PhoneNumberTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberTagRepository extends JpaRepository<PhoneNumberTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber_tag as tt where tt.phoneNumber_id=?1 and tt.tag_id=?2")
    PhoneNumberTag getPhoneNumberTagByPhoneNumberIdAndTagId(Long phoneNumberId, Long tagId);


}
