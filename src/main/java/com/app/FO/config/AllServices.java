package com.app.FO.config;

import com.app.FO.service.note.NoteService;
import com.app.FO.service.note.NoteTagService;
import com.app.FO.service.note.TagService;
import com.app.FO.service.note.TopicService;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AllServices {
    private UserService userService;
    private TagService tagService;
    private NoteService noteService;
    private TopicService topicService;
    private NoteTagService noteTagService;

    @Autowired
    public AllServices(UserService userService, TagService tagService, NoteService noteService,
                       TopicService topicService,NoteTagService noteTagService) {
        this.userService = userService;
        this.tagService = tagService;
        this.noteService = noteService;
        this.topicService = topicService;
        this.noteTagService=noteTagService;
    }

    public UserService getUserService() {
        return userService;
    }

    public TagService getTagService() {
        return tagService;
    }

    public NoteService getNoteService() {
        return noteService;
    }

    public TopicService getTopicService() {
        return topicService;
    }

    public NoteTagService getNoteTagService() {
        return noteTagService;
    }

}
