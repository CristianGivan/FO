package com.app.FO.repository.dates;

import com.app.FO.model.dates.DatesTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DatesTagRepository extends JpaRepository<DatesTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM dates_tag as tt where tt.dates_id=?1 and tt.tag_id=?2")
    DatesTag getDatesTagByDatesIdAndTagId(Long datesId, Long tagId);


}
