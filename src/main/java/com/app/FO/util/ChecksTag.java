package com.app.FO.util;

import com.app.FO.exceptions.NoteNotFoundException;
import com.app.FO.exceptions.TagAlreadyExistException;
import com.app.FO.exceptions.TagNotFoundException;
import com.app.FO.model.note.Note;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.user.User;
import com.app.FO.repository.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChecksTag {
    private TagRepository tagRepository;

    @Autowired
    public ChecksTag(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    public void checkIsTag(Tag tag){
        if(!isTag(tag)){
            throw new TagNotFoundException("Tag not found!");
        }
    }
    public void checkIsTagWithTagText(User user, String tagText){
        Tag tag =tagRepository.getTagsByUserIdAndTagText(user.getId(), tagText);
        if (tag != null) {
            throw new TagAlreadyExistException("Tag already exist");
        }
    }

    private Boolean isTag(Tag tag) {
        if (tag == null) {
            return false;
        }
        return true;
    }
}
