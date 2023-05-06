package com.app.FO.repository.tag;

import com.app.FO.model.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("select t from Tag as t inner join NoteTag nt on t.id=nt.tag.id " +
            "where nt.note.id=?1")
    List<Tag> getTagsByNoteId(Long noteId);
    @Query("select t from Tag as t inner join TopicTag tt on t.id=tt.tag.id " +
            "where tt.topic.id=?1")
    List<Tag> getTagsByTopicId(Long topicId);

    //@Query("select t from Tag as t inner join TagUser ut on t.id=ut.tag.id where ut.user.id=?1")

    //todo verific daca ii adevarat vezi query mai jos
    @Query(value = "SELECT * FROM tag as t inner join tag_user ut on t.tag_id = ut.tag_id where ut.user_id=?1"
            ,nativeQuery = true)
    List<Tag> getTagListByUserId(Long UserId);

    @Query(value = "SELECT * FROM tag as t inner join tag_user tu on t.tag_id = tu.tag_id where tu.user_id=?1 and t.tag_id=?2"
            ,nativeQuery = true)
    Tag getTagByUserIdAndTagId(Long UserId, Long tagId);

    //todo verific daca ii adevarat vezi query getTagByUserIdAndTagId
    @Query(value = "SELECT * FROM tag as t inner join tag_user ut on t.tag_id = ut.tag_id where ut.user_id=?1 and t.tag_text=?2"
            ,nativeQuery = true)
    Tag getTagsByUserIdAndTagText(Long UserId, String tagName);

    Tag findTagByTagText(String tagName);
}
