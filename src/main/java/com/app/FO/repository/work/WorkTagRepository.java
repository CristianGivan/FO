package com.app.FO.repository.work;

import com.app.FO.model.work.WorkTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTagRepository extends JpaRepository<WorkTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM work_tag as tt where tt.work_id=?1 and tt.tag_id=?2")
    WorkTag getWorkTagByWorkIdAndTagId(Long workId, Long tagId);


}
