package com.app.FO.dto;

import com.app.FO.dto.note.*;
import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagSDTO;
import com.app.FO.dto.topic.HistoryTopicSDTO;
import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.dto.topic.TopicSDTO;
import com.app.FO.dto.user.UserSDTO;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.note.*;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.topic.TopicHistory;
import com.app.FO.model.user.User;
import com.app.FO.service.note.NoteService;
import com.app.FO.service.note.TagService;
import com.app.FO.service.note.TopicService;
import com.app.FO.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConverterDTO {


    private TagService tagService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private NoteService noteService;

    @Autowired
    public ConverterDTO(TagService tagService) {
        this.tagService = tagService;
    }

    //Note

    public NoteDTO convertNoteToNoteDTO(Note note) {
        return new NoteDTO(note.getId(), note.getNote(),
                convertListOfTagToListOfTagSDTO(tagService.getListOfTagByNoteId(note.getId())),
                convertUserToUserSDTO(note.getUser()), note.getCreatedDate(),
                convertListOfTopicsToListOfTopicSDTO(topicService.getTopicsByNote(note)),
                convertListOfNoteHistoryToListOfNoteHistorySDTO(note.getNoteHistories())
        );
    }

    public List<NoteDTO> convertListOfNoteToListOfNoteDTO(List<Note> notes) {
        return notes.stream().map(this::convertNoteToNoteDTO).toList();
    }

    private NoteSDTO convertNoteToNoteSDTO(Note note) {
        return new NoteSDTO(note.getId(), note.getNote(), note.getCreatedDate());
    }

    private List<NoteSDTO> convertListOfNoteToListOfNoteSDTO(List<Note> notes) {
        return notes.stream().map(this::convertNoteToNoteSDTO).toList();
    }

    //Tag

    public TagDTO convertTagToTagDTO(Tag tag) {
        return new TagDTO(tag.getId(), tag.getTagName(),
                convertListOfNoteToListOfNoteSDTO(noteService.getNotesByTagId(tag.getId())),
                convertListOfTopicsToListOfTopicSDTO(topicService.getTopicsByTag(tag))
        );
    }

    public List<TagDTO> convertListOfTagToListOfTagDTO(List<Tag> tags) {
        return tags.stream().map(this::convertTagToTagDTO).toList();
    }

    private TagSDTO convertTagToTagSDTO(Tag tag) {
        return new TagSDTO(tag.getId(), tag.getTagName());
    }

    private List<TagSDTO> convertListOfTagToListOfTagSDTO(List<Tag> tags) {
        return tags.stream().map(this::convertTagToTagSDTO).toList();
    }

    public Tag convertTagSDTOToTag(TagSDTO tagSDTO){
        return new Tag(tagSDTO.getTag());
    }

    //Topic

    public TopicDTO convertTopicToTopicDTO(Topic topic) {
        return new TopicDTO(topic.getId(), topic.getSubject(),
                convertListOfNoteToListOfNoteSDTO(noteService.getNotesByTopicId(topic.getId())),
                convertListOfTagToListOfTagSDTO(tagService.getTagsByTopicId(topic.getId())),
                convertUserToUserSDTO(topic.getUser()),
                topic.getCreatedDate(),
                convertListOfTopicHistoryToListOfTopicHistorySDTO(topic.getTopicHistory())
        );
    }
    public List<TopicDTO> convertListOfTopicToListOfTopicDTO(List<Topic> topics){
        return topics.stream().map(this::convertTopicToTopicDTO).toList();
    }

    private TopicSDTO convertTopicToTopicsSDTO(Topic topic) {
        return new TopicSDTO(topic.getId(), topic.getSubject(), topic.getCreatedDate());
    }

    private List<TopicSDTO> convertListOfTopicsToListOfTopicSDTO(List<Topic> topics) {
        return topics.stream().map(this::convertTopicToTopicsSDTO).toList();
    }

    //NoteHistory

    private NoteHistoryDTO convertNoteHistoryToNoteHistoryDTO(NoteHistory noteHistory) {
        return new NoteHistoryDTO(noteHistory.getId(), noteHistory.getModifiedDate(),
                convertUserToUserSDTO(noteHistory.getUser()), convertNoteToNoteSDTO(noteHistory.getNote()),
                noteHistory.getNoteText());
    }

    private List<NoteHistoryDTO> convertListOfNoteHistoryToListOfNoteHistorySDTO(List<NoteHistory> noteHistories) {
        return noteHistories.stream().map(this::convertNoteHistoryToNoteHistoryDTO).toList();
    }

    //TopicHistory

    private HistoryTopicSDTO convertTopicHistoryToTopicHistorySDTO(TopicHistory topicHistory) {
        return new HistoryTopicSDTO(topicHistory.getId(), topicHistory.getModifiedDate(),
                convertUserToUserSDTO(topicHistory.getUser()));
    }
    private List<HistoryTopicSDTO> convertListOfTopicHistoryToListOfTopicHistorySDTO(List<TopicHistory> topicHistories){
        return topicHistories.stream().map(this::convertTopicHistoryToTopicHistorySDTO).toList();
    }

    //User

    private UserSDTO convertUserToUserSDTO(User user) {

        return new UserSDTO(user.getId(), user.getUsername(),
                roleService.getAllRolesByUserIdAsStrings(user.getId()));
    }
}
