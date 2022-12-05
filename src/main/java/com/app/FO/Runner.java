package com.app.FO;


import com.app.FO.dto.ConvertToDTO;
import com.app.FO.dto.note.NoteFDTO;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.note.Tag;
import com.app.FO.model.note.Topic;
import com.app.FO.model.user.Role;
import com.app.FO.model.user.RoleType;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserRole;
import com.app.FO.repository.note.TagRepository;
import com.app.FO.service.note.NoteService;
import com.app.FO.service.note.TagService;
import com.app.FO.service.note.TopicService;
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
    private ConvertToDTO convertToDTO;
    @Autowired
    private TagRepository tagRepository;

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
        dbInit();
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

        savedUser1.getUserRoles().add(userRole1);
        savedUser2.getUserRoles().add(userRole2);
        savedUser3.getUserRoles().add(userRole3);
        savedUser3.getUserRoles().add(userRole4);

        savedAdmin.getUserRoles().add(userRole1);
        savedAdmin.getUserRoles().add(userRole3);
        savedClient.getUserRoles().add(userRole2);
        savedClient.getUserRoles().add(userRole3);

        userRoleService.saveUserRole(userRole1);
        userRoleService.saveUserRole(userRole2);
        userRoleService.saveUserRole(userRole3);
        userRoleService.saveUserRole(userRole4);

        Topic topic1 = new Topic("subjectNote1", savedUser1, LocalDateTime.now().minusDays(1));
        Topic topic2 = new Topic("subjectNote2", savedUser2, LocalDateTime.now().minusDays(2));
        Topic topic3 = new Topic("subjectNote3", savedUser3, LocalDateTime.now().minusDays(3));
        Topic topic4 = new Topic("subjectNote4", savedUser3, LocalDateTime.now().minusDays(4));

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

        Note savedNote1 = noteService.saveNote(note1);
        Note savedNote2 = noteService.saveNote(note2);
        Note savedNote3 = noteService.saveNote(note3);

        NoteTag noteTag1 = new NoteTag(savedNote1, savedTag1, LocalDateTime.now().minusHours(1));
        NoteTag noteTag2 = new NoteTag(savedNote1, savedTag2, LocalDateTime.now().minusHours(1));
        NoteTag noteTag3 = new NoteTag(savedNote1, savedTag3, LocalDateTime.now().minusHours(1));
        NoteTag noteTag4 = new NoteTag(savedNote1, savedTag4, LocalDateTime.now().minusHours(1));
        NoteTag noteTag5 = new NoteTag(savedNote1, savedTag5, LocalDateTime.now().minusHours(1));
        NoteTag noteTag6 = new NoteTag(savedNote2, savedTag6, LocalDateTime.now().minusHours(1));
        NoteTag noteTag7 = new NoteTag(savedNote2, savedTag7, LocalDateTime.now().minusHours(1));
        NoteTag noteTag8 = new NoteTag(savedNote2, savedTag8, LocalDateTime.now().minusHours(1));
        NoteTag noteTag9 = new NoteTag(savedNote2, savedTag9, LocalDateTime.now().minusHours(1));
        NoteTag noteTag10 = new NoteTag(savedNote2, savedTag10, LocalDateTime.now().minusHours(1));
        NoteTag noteTag11 = new NoteTag(savedNote3, savedTag1, LocalDateTime.now().minusHours(3));
        NoteTag noteTag12 = new NoteTag(savedNote3, savedTag2, LocalDateTime.now().minusHours(3));
        NoteTag noteTag13 = new NoteTag(savedNote3, savedTag3, LocalDateTime.now().minusHours(3));
        NoteTag noteTag14 = new NoteTag(savedNote3, savedTag4, LocalDateTime.now().minusHours(3));
        NoteTag noteTag15 = new NoteTag(savedNote3, savedTag5, LocalDateTime.now().minusHours(3));
        NoteTag noteTag16 = new NoteTag(savedNote3, savedTag6, LocalDateTime.now().minusHours(3));
        NoteTag noteTag17 = new NoteTag(savedNote3, savedTag7, LocalDateTime.now().minusHours(3));
        NoteTag noteTag18 = new NoteTag(savedNote3, savedTag8, LocalDateTime.now().minusHours(3));
        NoteTag noteTag19 = new NoteTag(savedNote3, savedTag9, LocalDateTime.now().minusHours(3));

        savedNote1.getNoteTags().add(noteTag1);
        savedNote1.getNoteTags().add(noteTag2);
        savedNote1.getNoteTags().add(noteTag3);
        savedNote1.getNoteTags().add(noteTag4);
        savedNote1.getNoteTags().add(noteTag5);
        savedNote2.getNoteTags().add(noteTag6);
        savedNote2.getNoteTags().add(noteTag7);
        savedNote2.getNoteTags().add(noteTag8);
        savedNote2.getNoteTags().add(noteTag9);
        savedNote2.getNoteTags().add(noteTag10);
        savedNote3.getNoteTags().add(noteTag11);
        savedNote3.getNoteTags().add(noteTag12);
        savedNote3.getNoteTags().add(noteTag13);
        savedNote3.getNoteTags().add(noteTag14);
        savedNote3.getNoteTags().add(noteTag15);
        savedNote3.getNoteTags().add(noteTag16);
        savedNote3.getNoteTags().add(noteTag17);
        savedNote3.getNoteTags().add(noteTag18);
        savedNote3.getNoteTags().add(noteTag19);


        savedNote1 = noteService.saveNote(note1);
        savedNote2 = noteService.saveNote(note2);
        savedNote3 = noteService.saveNote(note3);

        NoteFDTO showNoteDTO=convertToDTO.convertNoteToShowNoteDTO(savedNote1);

        System.out.println(note1.getNoteTags());
        System.out.println(roleService.findRolesByUserId(1L));
        System.out.println("\n"+showNoteDTO);
        System.out.println("END");
    }
}