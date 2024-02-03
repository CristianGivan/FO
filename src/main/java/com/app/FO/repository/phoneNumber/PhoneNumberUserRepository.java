package com.app.FO.repository.phoneNumber;

import com.app.FO.model.phoneNumber.PhoneNumberUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberUserRepository extends JpaRepository<PhoneNumberUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM phoneNumber_user as tu where tu.phoneNumber_id=?1 and tu.user_id=?2")
    PhoneNumberUser getPhoneNumberUserByPhoneNumberIdAndUserId(Long phoneNumberId, Long userId);


}
