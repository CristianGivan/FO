package com.app.FO.repository.work;

import com.app.FO.model.work.WorkUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkUserRepository extends JpaRepository<WorkUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM work_user as tu where tu.work_id=?1 and tu.user_id=?2")
    WorkUser getWorkUserByWorkIdAndUserId(Long workId, Long userId);


}
