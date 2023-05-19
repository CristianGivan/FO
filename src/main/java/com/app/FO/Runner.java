package com.app.FO;


import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.topic.TopicNote;
import com.app.FO.model.topic.TopicTag;
import com.app.FO.model.user.Role;
import com.app.FO.model.user.RoleType;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserRole;
import com.app.FO.repository.note.NoteTagRepository;
import com.app.FO.service.note.NoteService;
import com.app.FO.service.tag.TagService;
import com.app.FO.service.topic.TopicService;
import com.app.FO.service.user.RoleService;
import com.app.FO.service.user.UserRoleService;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class Runner implements CommandLineRunner {


    private UserService userService;
    private RoleService roleService;
    private UserRoleService userRoleService;
    private TagService tagService;
    private NoteService noteService;
    private TopicService topicService;


    @Autowired
    private NoteTagRepository noteTagRepository;


    @Autowired
    public Runner(UserService userService, RoleService roleService, UserRoleService userRoleService,
                  TagService tagService, NoteService noteService, TopicService topicService) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
        this.tagService = tagService;
        this.noteService = noteService;
        this.topicService = topicService;
    }

    @Override
    @Transactional
    public void run(String... args) {
//      dbInit();


    }


    public void dbInit() {

        User user1 = new User("User1",
                "$2a$12$sJZ7/SZpCOTSeMg1jos87ulm.OcN31uQKnYisY/5r5XlNXSoQKPRi");//pas1
        User user2 = new User("User2",
                "$2a$12$gaUsXx4r4JlzHYXomu/XguBgQZbj2XXOWq5h683u7KCOPUozoRy56");//pas2
        User user3 = new User("User3",
                "$2a$12$b/jcMc9LC8sTk.8mV6Mzv.0GFCqgD7O/oK6m96nojFVKuGj8LlJv2");//pas3

        User savedUser1 = userService.saveUser(user1);
        User savedUser2 = userService.saveUser(user2);
        User savedUser3 = userService.saveUser(user3);

        Role admin = new Role(RoleType.ROLE_ADMIN);
        Role client = new Role(RoleType.ROLE_STANDARD);

        Role savedAdmin = roleService.saveRole(admin);
        Role savedClient = roleService.saveRole(client);

        UserRole userRole1 = new UserRole(savedUser1, savedAdmin);
        UserRole userRole2 = new UserRole(savedUser2, savedClient);
        UserRole userRole3 = new UserRole(savedUser3, savedClient);
        UserRole userRole4 = new UserRole(savedUser3, savedAdmin);

        savedUser1.getUserRoleList().add(userRole1);
        savedUser2.getUserRoleList().add(userRole2);
        savedUser3.getUserRoleList().add(userRole3);
        savedUser3.getUserRoleList().add(userRole4);

        savedAdmin.getUserRoleList().add(userRole1);
        savedAdmin.getUserRoleList().add(userRole3);
        savedClient.getUserRoleList().add(userRole2);
        savedClient.getUserRoleList().add(userRole3);

        userRoleService.saveUserRole(userRole1);
        userRoleService.saveUserRole(userRole2);
        userRoleService.saveUserRole(userRole3);
        userRoleService.saveUserRole(userRole4);


        Tag tag = new Tag("Tag", savedUser1);
        Tag tag12 = new Tag("Tag2", savedUser1);
        Tag tag13 = new Tag("Tag3", savedUser1);
        Tag tag14 = new Tag("Tag4", savedUser2);
        Tag tag15 = new Tag("Tag5", savedUser2);
        Tag tag16 = new Tag("Tag6", savedUser2);
        Tag tag17 = new Tag("Tag7", savedUser3);
        Tag tag18 = new Tag("Tag8", savedUser3);
        Tag tag19 = new Tag("Tag9", savedUser3);
        Tag tag110 = new Tag("Tag10", savedUser3);

        Tag savedTag11 = tagService.saveTag(tag);
        Tag savedTag21 = tagService.saveTag(tag12);
        Tag savedTag31 = tagService.saveTag(tag13);
        Tag savedTag41 = tagService.saveTag(tag14);
        Tag savedTag51 = tagService.saveTag(tag15);
        Tag savedTag61 = tagService.saveTag(tag16);
        Tag savedTag71 = tagService.saveTag(tag17);
        Tag savedTag81 = tagService.saveTag(tag18);
        Tag savedTag91 = tagService.saveTag(tag19);
        Tag savedTag101 = tagService.saveTag(tag110);

        Note note1 = new Note("Note1", savedUser1, LocalDateTime.now().minusDays(1));
        Note note2 = new Note("Note2", savedUser2, LocalDateTime.now().minusDays(2));
        Note note3 = new Note("Note3", savedUser3, LocalDateTime.now().minusDays(3));
        Note note4 = new Note("Note4", savedUser3, LocalDateTime.now().minusDays(3));

        Note savedNote1 = noteService.saveNote(note1);
        Note savedNote2 = noteService.saveNote(note2);
        Note savedNote3 = noteService.saveNote(note3);
        Note savedNote4 = noteService.saveNote(note4);

        NoteTag noteTag1 = new NoteTag(savedNote1, savedTag11);
        NoteTag noteTag2 = new NoteTag(savedNote1, savedTag21);
        NoteTag noteTag3 = new NoteTag(savedNote1, savedTag31);
        NoteTag noteTag4 = new NoteTag(savedNote1, savedTag41);
        NoteTag noteTag5 = new NoteTag(savedNote1, savedTag51);
        NoteTag noteTag6 = new NoteTag(savedNote2, savedTag61);
        NoteTag noteTag7 = new NoteTag(savedNote2, savedTag71);
        NoteTag noteTag8 = new NoteTag(savedNote2, savedTag81);
        NoteTag noteTag9 = new NoteTag(savedNote2, savedTag91);
        NoteTag noteTag10 = new NoteTag(savedNote2, savedTag101);
        NoteTag noteTag11 = new NoteTag(savedNote3, savedTag11);
        NoteTag noteTag12 = new NoteTag(savedNote3, savedTag21);
        NoteTag noteTag13 = new NoteTag(savedNote3, savedTag31);
        NoteTag noteTag14 = new NoteTag(savedNote3, savedTag41);
        NoteTag noteTag15 = new NoteTag(savedNote3, savedTag51);
        NoteTag noteTag16 = new NoteTag(savedNote3, savedTag61);
        NoteTag noteTag17 = new NoteTag(savedNote3, savedTag71);
        NoteTag noteTag18 = new NoteTag(savedNote3, savedTag81);
        NoteTag noteTag19 = new NoteTag(savedNote3, savedTag91);

        savedNote1.getNoteTagList().add(noteTag1);
        savedNote1.getNoteTagList().add(noteTag2);
        savedNote1.getNoteTagList().add(noteTag3);
        savedNote1.getNoteTagList().add(noteTag4);
        savedNote1.getNoteTagList().add(noteTag5);
        savedNote2.getNoteTagList().add(noteTag6);
        savedNote2.getNoteTagList().add(noteTag7);
        savedNote2.getNoteTagList().add(noteTag8);
        savedNote2.getNoteTagList().add(noteTag9);
        savedNote2.getNoteTagList().add(noteTag10);
        savedNote3.getNoteTagList().add(noteTag11);
        savedNote3.getNoteTagList().add(noteTag12);
        savedNote3.getNoteTagList().add(noteTag13);
        savedNote3.getNoteTagList().add(noteTag14);
        savedNote3.getNoteTagList().add(noteTag15);
        savedNote3.getNoteTagList().add(noteTag16);
        savedNote3.getNoteTagList().add(noteTag17);
        savedNote3.getNoteTagList().add(noteTag18);
        savedNote3.getNoteTagList().add(noteTag19);

        savedNote1 = noteService.saveNote(note1);
        savedNote2 = noteService.saveNote(note2);
        savedNote3 = noteService.saveNote(note3);

        Topic topic1 = new Topic("Topic1", savedUser1, LocalDateTime.now().minusDays(1));
        Topic topic2 = new Topic("Topic2", savedUser2, LocalDateTime.now().minusDays(2));
        Topic topic3 = new Topic("Topic3", savedUser3, LocalDateTime.now().minusDays(3));
        Topic topic4 = new Topic("Topic4", savedUser3, LocalDateTime.now().minusDays(4));

        Topic savedTopic1 = topicService.saveTopic(topic1);
        Topic savedTopic2 = topicService.saveTopic(topic2);
        Topic savedTopic3 = topicService.saveTopic(topic3);
        Topic savedTopic4 = topicService.saveTopic(topic4);

        TopicTag topicTag1 = new TopicTag(savedTopic1, savedTag11, LocalDateTime.now().minusHours(1));
        TopicTag topicTag2 = new TopicTag(savedTopic1, savedTag21, LocalDateTime.now().minusHours(1));
        TopicTag topicTag3 = new TopicTag(savedTopic1, savedTag31, LocalDateTime.now().minusHours(1));
        TopicTag topicTag4 = new TopicTag(savedTopic2, savedTag41, LocalDateTime.now().minusHours(1));
        TopicTag topicTag5 = new TopicTag(savedTopic2, savedTag51, LocalDateTime.now().minusHours(1));
        TopicTag topicTag6 = new TopicTag(savedTopic2, savedTag61, LocalDateTime.now().minusHours(1));
        TopicTag topicTag7 = new TopicTag(savedTopic3, savedTag71, LocalDateTime.now().minusHours(1));
        TopicTag topicTag8 = new TopicTag(savedTopic3, savedTag81, LocalDateTime.now().minusHours(1));
        TopicTag topicTag9 = new TopicTag(savedTopic3, savedTag91, LocalDateTime.now().minusHours(1));
        TopicTag topicTag10 = new TopicTag(savedTopic3, savedTag101, LocalDateTime.now().minusHours(1));


        savedTopic1.getTopicTagList().add(topicTag1);
        savedTopic1.getTopicTagList().add(topicTag2);
        savedTopic1.getTopicTagList().add(topicTag3);
        savedTopic2.getTopicTagList().add(topicTag4);
        savedTopic2.getTopicTagList().add(topicTag5);
        savedTopic2.getTopicTagList().add(topicTag6);
        savedTopic3.getTopicTagList().add(topicTag7);
        savedTopic3.getTopicTagList().add(topicTag8);
        savedTopic3.getTopicTagList().add(topicTag9);
        savedTopic3.getTopicTagList().add(topicTag10);

        TopicNote topicNote1 = new TopicNote(savedTopic1, savedNote1, LocalDateTime.now());
        TopicNote topicNote2 = new TopicNote(savedTopic1, savedNote2, LocalDateTime.now());
        TopicNote topicNote3 = new TopicNote(savedTopic1, savedNote3, LocalDateTime.now());
        TopicNote topicNote4 = new TopicNote(savedTopic2, savedNote1, LocalDateTime.now());
        TopicNote topicNote5 = new TopicNote(savedTopic2, savedNote2, LocalDateTime.now());
        TopicNote topicNote6 = new TopicNote(savedTopic2, savedNote3, LocalDateTime.now());
        TopicNote topicNote7 = new TopicNote(savedTopic3, savedNote1, LocalDateTime.now());
        TopicNote topicNote8 = new TopicNote(savedTopic3, savedNote2, LocalDateTime.now());
        TopicNote topicNote9 = new TopicNote(savedTopic3, savedNote3, LocalDateTime.now());

        savedTopic1.getTopicNoteList().add(topicNote1);
        savedTopic1.getTopicNoteList().add(topicNote2);
        savedTopic1.getTopicNoteList().add(topicNote3);
        savedTopic2.getTopicNoteList().add(topicNote4);
        savedTopic2.getTopicNoteList().add(topicNote5);
        savedTopic2.getTopicNoteList().add(topicNote6);
        savedTopic3.getTopicNoteList().add(topicNote7);
        savedTopic3.getTopicNoteList().add(topicNote8);
        savedTopic3.getTopicNoteList().add(topicNote9);


        savedTopic1 = topicService.saveTopic(topic1);
        savedTopic2 = topicService.saveTopic(topic2);
        savedTopic3 = topicService.saveTopic(topic3);

    }
}