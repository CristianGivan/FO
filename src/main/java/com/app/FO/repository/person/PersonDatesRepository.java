package com.app.FO.repository.person;

import com.app.FO.model.person.PersonDates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDatesRepository extends JpaRepository<PersonDates, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_dates as tt where tt.person_id=?1 and tt.dates_id=?2")
    PersonDates getPersonDatesByPersonIdAndDatesId(Long personId, Long datesId);


}
