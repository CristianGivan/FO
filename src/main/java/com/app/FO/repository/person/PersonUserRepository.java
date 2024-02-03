package com.app.FO.repository.person;

import com.app.FO.model.person.PersonUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonUserRepository extends JpaRepository<PersonUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_user as tu where tu.person_id=?1 and tu.user_id=?2")
    PersonUser getPersonUserByPersonIdAndUserId(Long personId, Long userId);


}
