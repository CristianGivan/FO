package com.app.FO.repository.note;

import com.app.FO.model.note.NoteTag;
import com.app.FO.model.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findAll();
    Tag findTagByNoteTags(NoteTag noteTag);

    @Query("select t from Tag as t inner join NoteTag nt on t.id=nt.tag.id " +
            "where nt.note.id=?1")
    List<Tag> getTagsByNoteId(Long noteId);
    @Query("select t from Tag as t inner join TopicTag tt on t.id=tt.tag.id " +
            "where tt.topic.id=?1")
    List<Tag> getTagsByTopicId(Long topicId);

    //@Query("select t from Tag as t inner join UserTag ut on t.id=ut.tag.id where ut.user.id=?1")

    //todo verific daca ii adevarat vezi query mai jos
    @Query(value = "SELECT * FROM tags as t inner join user_tag ut on t.tag_id = ut.tag_id where user_id=?1"
            ,nativeQuery = true)
    List<Tag> getTagsByUserId(Long UserId);

    @Query(value = "SELECT * FROM tags as t inner join user_tag ut on t.tag_id = ut.tag_id where ut.user_id=?1 and ut.tag_id=?2"
            ,nativeQuery = true)
    Tag getTagByUserIdAndTagId(Long UserId, Long tagId);

    //todo verific daca ii adevarat vezi query getTagByUserIdAndTagId
    @Query(value = "SELECT * FROM tags as t inner join user_tag ut on t.tag_id = ut.tag_id where user_id=?1 and t.tag=?2"
            ,nativeQuery = true)
    Tag getTagsByUserIdAndTagName(Long UserId,String tagName);

    Tag findTagByTagName(String tagName);
}
