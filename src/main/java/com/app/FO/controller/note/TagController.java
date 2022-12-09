package com.app.FO.controller.note;

import com.app.FO.dto.ConverterDTO;
import com.app.FO.dto.note.TagDTO;
import com.app.FO.dto.note.TagSDTO;
import com.app.FO.dto.note.TextDTO;
import com.app.FO.service.note.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    private TagService tagService;
    @Autowired
    private ConverterDTO converterDTO;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/addNewTag")
    public TagDTO addNewTag(@RequestBody TextDTO tagText) {
        return converterDTO.convertTagToTagDTO(
                tagService.saveTagFromText(tagText.getText()));
    }
    @PostMapping("/addNewTag1")
    public TagDTO addNewTag(@RequestBody TagSDTO tagSDTO) {
        return converterDTO.convertTagToTagDTO(
                tagService.saveTagFromText(tagSDTO.getTag()));
    }

    @GetMapping("/getAllTags")
    public List<TagDTO> getAllTags() {
        return converterDTO.convertListOfTagToListOfTagDTO(tagService.getAllTags());
    }

    @GetMapping("/getTagById/{tagId}")
    public TagDTO getTagById(@PathVariable Long tagId) {
        return converterDTO.convertTagToTagDTO(tagService.getTagById(tagId));
    }

    @GetMapping("/getTagByName/{tagName}")
    public List<TagDTO> getTagByName(@PathVariable String tagName) {
        return converterDTO.convertListOfTagToListOfTagDTO(
                tagService.getTagsByName(tagName));
    }

    @GetMapping("/getTagByNoteId/{noteId}")
    public List<TagDTO> getTagByNoteId(@PathVariable Long noteId) {
        return converterDTO.convertListOfTagToListOfTagDTO(
                tagService.getListOfTagByNoteId(noteId));
    }
    @GetMapping("/getTagByTopicId/{topicId}")
    public List<TagDTO> getTagByTopicId(@PathVariable Long topicId) {
        return converterDTO.convertListOfTagToListOfTagDTO(
                tagService.getListOfTagByNoteId(topicId));
    }

}
