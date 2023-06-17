package com.app.FO.repository.tag;

import com.app.FO.model.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM tag as t inner join tag_user tu on t.tag_id = tu.tag_id where tu.user_id=?1")
    List<Tag> getTagListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tag as t inner join tag_user tu on t.tag_id = tu.tag_id where tu.user_id=?1 and tu.tag_id=?2")
    Tag getTagFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tag as t inner join tag_user tu on t.tag_id = tu.tag_id where tu.user_id=?1 and t.subject=?2")
    Tag getTagFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tag as t inner join tag_user ut on t.tag_id = ut.tag_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Tag> getTagListFromUserIdBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String subjectText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tag as t inner join tag_user tu on t.tag_id = tu.tag_id where tu.user_id=?1 and t.created_date=?2")
    Tag getTagFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tag as t inner join tag_user ut on t.tag_id = ut.tag_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Tag> getTagListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM tag as t inner join (SELECT ti.tag_id FROM (SELECT t.tag_id FROM tag as t inner join tag_user tu on t.tag_id = tu.tag_id where tu.user_id=?1) as ti inner join tag_user tu on ti.tag_id = tu.tag_id where tu.user_id=?2)as tr on tr.tag_id=t.tag_id")
    List<Tag> getTagListFromUserIdByUserId(Long logInUserId, Long userId);


//    
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM tag as t inner join note_tag as nt on t.tag_id = nt.tag_id inner join tag_user tu on t.tag_id = tu.tag_id where tu.user_id=?1 and nt.note_id=?2")
//    List<Tag> getTagsByNoteId(Long userId, Long noteId);
//
//    //    @Query("select t from Tag as t inner join TopicTag tt on t.id=tt.tag.id " +
////            "where tt.topic.id=?1")
//    //todo tbc with the testing
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM tag as t inner join topic_tag as tt on t.tag_id = tt.tag_id inner join tag_user tu on t.tag_id = tu.tag_id where tu.user_id=?1 and tt.topic_id=?2")
//    List<Tag> getTagListByUserIdAndTopicId(Long userId, Long topicId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM tag as t inner join tag_user ut on t.tag_id = ut.tag_id where ut.user_id=?1")
//    List<Tag> getTagListByUserId(Long UserId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM tag as t inner join tag_user tu on t.tag_id = tu.tag_id where tu.user_id=?1 and t.tag_id=?2")
//    Tag getTagFromUserIdAndTagId(Long UserId, Long tagId);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM tag as t inner join tag_user ut on t.tag_id = ut.tag_id where ut.user_id=?1 and t.subject=?2")
//    Tag getTagsByUserIdAndTagText(Long UserId, String subject);
//
//    @Query(nativeQuery = true, value =
//            "SELECT * FROM tag as t inner join tag_user ut on t.tag_id = ut.tag_id where ut.user_id=:userId and t.subject like %:subject%")
//    List<Tag> getTagListByUserIdAndContainingTagSubject(@Param("userId") Long UserId, @Param("subject") String subject);
//
//    @Query(nativeQuery = true, value =
//            "SELECT IF(EXISTS(SELECT * FROM tag_user as tu where tu.tag_id = ?1 and tu.user_id = ?2), 'True', 'False')")
//    Boolean tagIdHasUserId(Long tagId, Long userId);
//

}