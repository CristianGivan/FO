package com.app.FO.repository.link;

import com.app.FO.model.link.LinkUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkUserRepository extends JpaRepository<LinkUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM link_user as tu where tu.link_id=?1 and tu.user_id=?2")
    LinkUser getLinkUserByLinkIdAndUserId(Long linkId, Long userId);


}
