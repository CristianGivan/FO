package com.app.FO.repository.topic;

import com.app.FO.model.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic as t inner join topic_user tu on t.topic_id = tu.topic_id where tu.user_id=?1")
    List<Topic> getTopicListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic as t inner join topic_user tu on t.topic_id = tu.topic_id where tu.user_id=?1 and tu.topic_id=?2")
    Topic getTopicFromUserIdByTopicId(Long userId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic as t inner join topic_user tu on t.topic_id = tu.topic_id where tu.user_id=?1 and t.subject=?2")
    Topic getTopicFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic as t inner join topic_user ut on t.topic_id = ut.topic_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Topic> getTopicListBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String tagText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic as t inner join topic_note as tn on t.topic_id = tn.topic_id inner join topic_user tu on t.topic_id = tu.topic_id where tu.user_id=?1 and tn.note_id=?2")
    List<Topic> getTopicListFromUserIdByNoteId(Long userId, Long noteId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic as t inner join topic_tag as tt on t.topic_id = tt.topic_id inner join topic_user tu on t.topic_id = tu.topic_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Topic> getTopicListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM topic as t inner join topic_reminder as tr on t.topic_id = tr.topic_id inner join topic_user tu on t.topic_id = tu.topic_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Topic> getTopicListFromUserIdByReminderId(Long userId, Long reminderId);

}
