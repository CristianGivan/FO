package com.app.FO.repository.person;

import com.app.FO.model.person.PersonPhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPhoneNumberRepository extends JpaRepository<PersonPhoneNumber, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_phone_number as tt where tt.person_id=?1 and tt.phone_number_id=?2")
    PersonPhoneNumber getPersonPhoneNumberByPersonIdAndPhoneNumberId(Long personId, Long phoneNumberId);


}
