package com.app.FO.repository.person;

import com.app.FO.model.person.PersonTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonTagRepository extends JpaRepository<PersonTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM person_tag as tt where tt.person_id=?1 and tt.tag_id=?2")
    PersonTag getPersonTagByPersonIdAndTagId(Long personId, Long tagId);


}
