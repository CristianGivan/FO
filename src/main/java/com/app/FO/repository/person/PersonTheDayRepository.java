package com.app.FO.repository.person;

import com.app.FO.model.person.PersonTheDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonTheDayRepository extends JpaRepository<PersonTheDay, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_the_day as tt where tt.person_id=?1 and tt.the_day_id=?2")
    PersonTheDay getPersonTheDayByPersonIdAndTheDayId(Long personId, Long theDayId);


}
