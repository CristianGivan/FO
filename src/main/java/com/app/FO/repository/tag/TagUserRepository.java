package com.app.FO.repository.tag;

import com.app.FO.model.note.NoteUser;
import com.app.FO.model.tag.TagUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TagUserRepository extends JpaRepository<TagUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM tag_user as tu where tu.tag_id=?1 and tu.user_id=?2")
    public TagUser getTagUserByTagIdAndUserId(Long tagId, Long userId);

}
