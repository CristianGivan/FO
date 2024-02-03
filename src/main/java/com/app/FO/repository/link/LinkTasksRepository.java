package com.app.FO.repository.link;

import com.app.FO.model.link.LinkTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LinkTasksRepository extends JpaRepository<LinkTasks, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM link_tasks as tt where tt.link_id=?1 and tt.tasks_id=?2")
    LinkTasks getLinkTasksByLinkIdAndTasksId(Long linkId, Long topicId);


}
