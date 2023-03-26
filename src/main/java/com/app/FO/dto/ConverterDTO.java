//package com.app.FO.dto;
//
//import com.app.FO.dto.note.*;
//import com.app.FO.dto.tag.TagDTO;
//import com.app.FO.dto.tag.TagFDTO;
//import com.app.FO.dto.topic.HistoryTopicSDTO;
//import com.app.FO.dto.topic.TopicFDTO;
//import com.app.FO.dto.topic.TopicDTO;
//import com.app.FO.dto.user.UserDTO;
//import com.app.FO.model.tag.Tag;
//import com.app.FO.model.note.*;
//import com.app.FO.model.topic.Topic;
//import com.app.FO.model.topic.TopicHistory;
//import com.app.FO.model.user.User;
//import com.app.FO.service.note.NoteService;
//import com.app.FO.service.tag.TagService;
//import com.app.FO.service.topic.TopicService;
//import com.app.FO.service.user.RoleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Configuration
//public class ConverterDTO {
//
//
//    private TagService tagService;
//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private TopicService topicService;
//    @Autowired
//    private NoteService noteService;
//
//    @Autowired
//    public ConverterDTO(TagService tagService) {
//        this.tagService = tagService;
//    }
//
//    //Note
//
//    public NoteFDTO convertNoteToNoteDTO(Note note) {
//        return new NoteFDTO(note.getId(), note.getNote(), note.getCreatedDate(), convertUserToUserSDTO(note.getUser()),
//                convertListOfTagToListOfTagSDTO(tagService.getListOfTagByNoteId(note.getId()))
////                ,convertListOfTopicsToListOfTopicSDTO(topicService.getTopicsByNote(note)),
////                convertListOfNoteHistoryToListOfNoteHistorySDTO(note.getNoteHistories())
//        );
//    }
//
//    public List<NoteFDTO> convertListOfNoteToListOfNoteDTO(List<Note> notes) {
//        return notes.stream().map(this::convertNoteToNoteDTO).collect(Collectors.toList());
//    }
//
//    private NoteDTO convertNoteToNoteSDTO(Note note) {
//        return new NoteDTO(note.getId(), note.getNote(), note.getCreatedDate());
//    }
//
//    private List<NoteDTO> convertListOfNoteToListOfNoteSDTO(List<Note> notes) {
//        return notes.stream().map(this::convertNoteToNoteSDTO).collect(Collectors.toList());
//    }
//
//    //Tag
//
//    public TagFDTO convertTagToTagDTO(Tag tag) {
//        return new TagFDTO(tag.getId(), tag.getTagName(),
//                convertListOfNoteToListOfNoteSDTO(noteService.getNotesByTagId(tag.getId())),
//                convertListOfTopicsToListOfTopicSDTO(topicService.getTopicsByTag(tag))
//        );
//    }
//
//    public List<TagFDTO> convertListOfTagToListOfTagDTO(List<Tag> tags) {
//        return tags.stream().map(this::convertTagToTagDTO).collect(Collectors.toList());
//    }
//
//    private TagDTO convertTagToTagSDTO(Tag tag) {
//        return new TagDTO(tag.getId(), tag.getTagName());
//    }
////
////    private List<TagDTO> convertListOfTagToListOfTagDTO(List<Tag> tags) {
////        return tags.stream().map(this::convertTagToTagGDTO).collect(Collectors.toList());
////    }
////
////    public Tag convertTagSDTOToTag(TagDTO tagDTO){
////        return new Tag(tagDTO.getTag());
////    }
//
//    //Topic
//
//    public TopicFDTO convertTopicToTopicDTO(Topic topic) {
//        return new TopicFDTO(topic.getId(), topic.getSubject(),
//                convertListOfNoteToListOfNoteSDTO(noteService.getNotesByTopicId(topic.getId())),
//                convertListOfTagToListOfTagDTO(tagService.getTagsByTopicId(topic.getId())),
//                convertUserToUserSDTO(topic.getUser()),
//                topic.getCreatedDate(),
//                convertListOfTopicHistoryToListOfTopicHistorySDTO(topic.getTopicHistory())
//        );
//    }
//    public List<TopicFDTO> convertListOfTopicToListOfTopicDTO(List<Topic> topics){
//        return topics.stream().map(this::convertTopicToTopicDTO).collect(Collectors.toList());
//    }
//
//    private TopicDTO convertTopicToTopicsSDTO(Topic topic) {
//        return new TopicDTO(topic.getId(), topic.getSubject(), topic.getCreatedDate());
//    }
//
//    private List<TopicDTO> convertListOfTopicsToListOfTopicSDTO(List<Topic> topics) {
//        return topics.stream().map(this::convertTopicToTopicsSDTO).collect(Collectors.toList());
//    }
//
//    //NoteHistory
//
//    private NoteHistoryDTO convertNoteHistoryToNoteHistoryDTO(NoteHistory noteHistory) {
//        return new NoteHistoryDTO(noteHistory.getId(), noteHistory.getModifiedDate(),
//                convertUserToUserSDTO(noteHistory.getUser()), convertNoteToNoteSDTO(noteHistory.getNote()),
//                noteHistory.getNoteText());
//    }
//
//    private List<NoteHistoryDTO> convertListOfNoteHistoryToListOfNoteHistorySDTO(List<NoteHistory> noteHistories) {
//        return noteHistories.stream().map(this::convertNoteHistoryToNoteHistoryDTO).collect(Collectors.toList());
//    }
//
//    //TopicHistory
//
//    private HistoryTopicSDTO convertTopicHistoryToTopicHistorySDTO(TopicHistory topicHistory) {
//        return new HistoryTopicSDTO(topicHistory.getId(), topicHistory.getModifiedDate(),
//                convertUserToUserSDTO(topicHistory.getUser()));
//    }
//    private List<HistoryTopicSDTO> convertListOfTopicHistoryToListOfTopicHistorySDTO(List<TopicHistory> topicHistories){
//        return topicHistories.stream().map(this::convertTopicHistoryToTopicHistorySDTO).collect(Collectors.toList());
//    }
//
//    //User
//
//    private UserDTO convertUserToUserSDTO(User user) {
//
//        return new UserDTO(user.getId(), user.getUsername(),
//                roleService.getAllRolesByUserIdAsStrings(user.getId()));
//    }
//}
