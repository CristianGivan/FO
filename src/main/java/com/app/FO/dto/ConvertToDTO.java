package com.app.FO.dto;

import com.app.FO.dto.note.ShowNoteDTO;
import com.app.FO.dto.note.ShowNoteHistoryShortDTO;
import com.app.FO.dto.note.ShowTagShortDTO;
import com.app.FO.dto.note.ShowTopicShortDTO;
import com.app.FO.dto.user.ShowUserShortDTO;
import com.app.FO.exceptions.NoteHistoryException;
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

    public ShowNoteDTO convertNoteToShowNoteDTO(Note note) {
        return new ShowNoteDTO(note.getId(), note.getNote(),
                convertListOfTagToListOfShowTagsShortDTO(tagService.getAllTagsFromNote(note)),
                convertUserToShowUserShortDTO(note.getUser()), note.getCreatedDate(),
                convertListOfTopicsToListOfShowTopicShortDTO(topicService.getAllTopicsOfANote(note)),
                convertListOfNoteHistoryToShowNoteHistoryDTO(note.getNoteHistories())
        );
    }

    public List<ShowNoteDTO> convertListOfNoteToListOfShowNoteDTO(List<Note> notes) {
        return notes.stream().map(this::convertNoteToShowNoteDTO).toList();
    }


    private ShowTagShortDTO convertTagToShowTagShortDTO(Tag tag) {
        return new ShowTagShortDTO(tag.getId(), tag.getTagName());
    }

    private List<ShowTagShortDTO> convertListOfTagToListOfShowTagsShortDTO(List<Tag> tags) {
        return tags.stream().map(this::convertTagToShowTagShortDTO).toList();
    }


    private ShowUserShortDTO convertUserToShowUserShortDTO(User user) {
        return new ShowUserShortDTO(user.getId(), user.getUsername(),
                roleService.getAllRolesByUserIdAsStrings(user.getId()));
    }

    private ShowTopicShortDTO convertTopicToShowTopicsShortDTO(Topic topic) {
        return new ShowTopicShortDTO(topic.getId(), topic.getSubject(), topic.getCreatedDate());
    }

    private List<ShowTopicShortDTO> convertListOfTopicsToListOfShowTopicShortDTO(List<Topic> topics) {
        return topics.stream().map(this::convertTopicToShowTopicsShortDTO).toList();
    }

    private ShowNoteHistoryShortDTO convertNoteHistoryToShowNoteHistoryDTO(NoteHistory noteHistory) {
        return new ShowNoteHistoryShortDTO(noteHistory.getId(), noteHistory.getModifiedDate());
    }

    private List<ShowNoteHistoryShortDTO> convertListOfNoteHistoryToShowNoteHistoryDTO(List<NoteHistory> noteHistories) {
//        if (noteHistories == null) {
//            throw new NoteHistoryException("No note histories found");
//        } else {
            return noteHistories.stream().map(this::convertNoteHistoryToShowNoteHistoryDTO).toList();
 //       }
    }

}
