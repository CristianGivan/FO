package com.app.FO.repository.person;

import com.app.FO.model.person.PersonPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPersonRepository extends JpaRepository<PersonPerson, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_person as tt where tt.person_id=?1 and tt.related_person_id=?2")
    PersonPerson getPersonPersonByPersonIdAndPersonId(Long personId, Long relatedPersonId);
}
