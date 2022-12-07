package com.app.FO.controller.note;

import com.app.FO.dto.ConvertToDTO;
import com.app.FO.dto.note.TagDTO;
import com.app.FO.model.note.Tag;
import com.app.FO.service.note.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    private TagService tagService;
    @Autowired
    private ConvertToDTO convertToDTO;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/getAllTags")
    public List<TagDTO> getAllTags(){
        return convertToDTO.convertListOfTagToListOfTagDTO(tagService.getAllTags());
    }
    @GetMapping("/getTagById/{tagId}")
    public TagDTO getTagById(@PathVariable Long tagId){
        return convertToDTO.convertTagToTagDTO(tagService.getTagById(tagId));
    }


}
