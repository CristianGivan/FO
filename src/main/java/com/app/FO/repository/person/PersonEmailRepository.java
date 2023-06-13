package com.app.FO.repository.person;

import com.app.FO.model.person.PersonEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEmailRepository extends JpaRepository<PersonEmail, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_mail as tt where tt.person_id=?1 and tt.email_id=?2")
    PersonEmail getPersonEmailByPersonIdAndEmailId(Long personId, Long mailId);


}
