package com.app.FO.repository.theDay;

import com.app.FO.model.theDay.TheDayTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TheDayTagRepository extends JpaRepository<TheDayTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM theDay_tag as tt where tt.theDay_id=?1 and tt.tag_id=?2")
    TheDayTag getTheDayTagByTheDayIdAndTagId(Long theDayId, Long tagId);


}
