package com.app.FO.repository.link;

import com.app.FO.model.link.LinkTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkTagRepository extends JpaRepository<LinkTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM link_tag as tt where tt.link_id=?1 and tt.tag_id=?2")
    LinkTag getLinkTagByLinkIdAndTagId(Long linkId, Long tagId);


}
