package com.app.FO.dto;

import com.app.FO.dto.note.NoteFDTO;
import com.app.FO.dto.note.HistoryNoteSDTO;
import com.app.FO.dto.note.TagSDTO;
import com.app.FO.dto.note.TopicSDTO;
import com.app.FO.dto.user.ShowUserShortDTO;
import com.app.FO.model.note.NoteHistory;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.Tag;
import com.app.FO.model.note.Topic;
import com.app.FO.model.user.User;
import com.app.FO.service.note.TagService;
import com.app.FO.service.note.TopicService;
import com.app.FO.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConvertToDTO {


    private TagService tagService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TopicService topicService;

    @Autowired
    public ConvertToDTO(TagService tagService) {
        this.tagService = tagService;
    }

    public NoteFDTO convertNoteToShowNoteDTO(Note note) {
        return new NoteFDTO(note.getId(), note.getNote(),
                convertListOfTagToListOfShowTagsShortDTO(tagService.getAllTagsFromNote(note)),
                convertUserToShowUserShortDTO(note.getUser()), note.getCreatedDate(),
                convertListOfTopicsToListOfShowTopicShortDTO(topicService.getAllTopicsOfANote(note)),
                convertListOfNoteHistoryToShowNoteHistoryDTO(note.getNoteHistories())
        );
    }

    public List<NoteFDTO> convertListOfNoteToListOfShowNoteDTO(List<Note> notes) {
        return notes.stream().map(this::convertNoteToShowNoteDTO).toList();
    }


    private TagSDTO convertTagToShowTagShortDTO(Tag tag) {
        return new TagSDTO(tag.getId(), tag.getTagName());
    }

    private List<TagSDTO> convertListOfTagToListOfShowTagsShortDTO(List<Tag> tags) {
        return tags.stream().map(this::convertTagToShowTagShortDTO).toList();
    }


    private ShowUserShortDTO convertUserToShowUserShortDTO(User user) {
        return new ShowUserShortDTO(user.getId(), user.getUsername(),
                roleService.getAllRolesByUserIdAsStrings(user.getId()));
    }

    private TopicSDTO convertTopicToShowTopicsShortDTO(Topic topic) {
        return new TopicSDTO(topic.getId(), topic.getSubject(), topic.getCreatedDate());
    }

    private List<TopicSDTO> convertListOfTopicsToListOfShowTopicShortDTO(List<Topic> topics) {
        return topics.stream().map(this::convertTopicToShowTopicsShortDTO).toList();
    }

    private HistoryNoteSDTO convertNoteHistoryToShowNoteHistoryDTO(NoteHistory noteHistory) {
        return new HistoryNoteSDTO(noteHistory.getId(), noteHistory.getModifiedDate());
    }

    private List<HistoryNoteSDTO> convertListOfNoteHistoryToShowNoteHistoryDTO(List<NoteHistory> noteHistories) {
//        if (noteHistories == null) {
//            throw new NoteHistoryException("No note histories found");
//        } else {
            return noteHistories.stream().map(this::convertNoteHistoryToShowNoteHistoryDTO).toList();
 //       }
    }

}
