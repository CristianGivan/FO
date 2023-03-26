package com.app.FO;


import com.app.FO.model.tag.Tag;
import com.app.FO.model.note.*;
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
    public void run(String... args) throws Exception {
//        dbInit();


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
        Role client = new Role(RoleType.ROLE_CLIENT);

        Role savedAdmin = roleService.saveRole(admin);
        Role savedClient = roleService.saveRole(client);

        UserRole userRole1 = new UserRole(savedUser1, savedAdmin, LocalDateTime.now());
        UserRole userRole2 = new UserRole(savedUser2, savedClient, LocalDateTime.now());
        UserRole userRole3 = new UserRole(savedUser3, savedClient, LocalDateTime.now());
        UserRole userRole4 = new UserRole(savedUser3, savedAdmin, LocalDateTime.now());

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


        Tag tag1 = new Tag("Tag1");
        Tag tag2 = new Tag("Tag2");
        Tag tag3 = new Tag("Tag3");
        Tag tag4 = new Tag("Tag4");
        Tag tag5 = new Tag("Tag5");
        Tag tag6 = new Tag("Tag6");
        Tag tag7 = new Tag("Tag7");
        Tag tag8 = new Tag("Tag8");
        Tag tag9 = new Tag("Tag9");
        Tag tag10 = new Tag("Tag10");

        Tag savedTag1 = tagService.saveTag(tag1);
        Tag savedTag2 = tagService.saveTag(tag2);
        Tag savedTag3 = tagService.saveTag(tag3);
        Tag savedTag4 = tagService.saveTag(tag4);
        Tag savedTag5 = tagService.saveTag(tag5);
        Tag savedTag6 = tagService.saveTag(tag6);
        Tag savedTag7 = tagService.saveTag(tag7);
        Tag savedTag8 = tagService.saveTag(tag8);
        Tag savedTag9 = tagService.saveTag(tag9);
        Tag savedTag10 = tagService.saveTag(tag10);

        Note note1 = new Note("Note1", savedUser1, LocalDateTime.now().minusDays(1));
        Note note2 = new Note("Note2", savedUser2, LocalDateTime.now().minusDays(2));
        Note note3 = new Note("Note3", savedUser3, LocalDateTime.now().minusDays(3));
        Note note4 = new Note("Note4", savedUser3, LocalDateTime.now().minusDays(3));

        Note savedNote1 = noteService.saveNote(note1);
        Note savedNote2 = noteService.saveNote(note2);
        Note savedNote3 = noteService.saveNote(note3);
        Note savedNote4 = noteService.saveNote(note4);

        NoteTag noteTag1 = new NoteTag(savedNote1, savedTag1);
        NoteTag noteTag2 = new NoteTag(savedNote1, savedTag2);
        NoteTag noteTag3 = new NoteTag(savedNote1, savedTag3);
        NoteTag noteTag4 = new NoteTag(savedNote1, savedTag4);
        NoteTag noteTag5 = new NoteTag(savedNote1, savedTag5);
        NoteTag noteTag6 = new NoteTag(savedNote2, savedTag6);
        NoteTag noteTag7 = new NoteTag(savedNote2, savedTag7);
        NoteTag noteTag8 = new NoteTag(savedNote2, savedTag8);
        NoteTag noteTag9 = new NoteTag(savedNote2, savedTag9);
        NoteTag noteTag10 = new NoteTag(savedNote2, savedTag10);
        NoteTag noteTag11 = new NoteTag(savedNote3, savedTag1);
        NoteTag noteTag12 = new NoteTag(savedNote3, savedTag2);
        NoteTag noteTag13 = new NoteTag(savedNote3, savedTag3);
        NoteTag noteTag14 = new NoteTag(savedNote3, savedTag4);
        NoteTag noteTag15 = new NoteTag(savedNote3, savedTag5);
        NoteTag noteTag16 = new NoteTag(savedNote3, savedTag6);
        NoteTag noteTag17 = new NoteTag(savedNote3, savedTag7);
        NoteTag noteTag18 = new NoteTag(savedNote3, savedTag8);
        NoteTag noteTag19 = new NoteTag(savedNote3, savedTag9);

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

        TopicTag topicTag1 = new TopicTag(savedTopic1, savedTag1, LocalDateTime.now().minusHours(1));
        TopicTag topicTag2 = new TopicTag(savedTopic1, savedTag2, LocalDateTime.now().minusHours(1));
        TopicTag topicTag3 = new TopicTag(savedTopic1, savedTag3, LocalDateTime.now().minusHours(1));
        TopicTag topicTag4 = new TopicTag(savedTopic2, savedTag4, LocalDateTime.now().minusHours(1));
        TopicTag topicTag5 = new TopicTag(savedTopic2, savedTag5, LocalDateTime.now().minusHours(1));
        TopicTag topicTag6 = new TopicTag(savedTopic2, savedTag6, LocalDateTime.now().minusHours(1));
        TopicTag topicTag7 = new TopicTag(savedTopic3, savedTag7, LocalDateTime.now().minusHours(1));
        TopicTag topicTag8 = new TopicTag(savedTopic3, savedTag8, LocalDateTime.now().minusHours(1));
        TopicTag topicTag9 = new TopicTag(savedTopic3, savedTag9, LocalDateTime.now().minusHours(1));
        TopicTag topicTag10 = new TopicTag(savedTopic3, savedTag10, LocalDateTime.now().minusHours(1));


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