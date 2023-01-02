package com.app.FO.controller.note;

import com.app.FO.config.AllServices;
import com.app.FO.dto.note.NoteFDTO;
import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagFDTO;
import com.app.FO.dto.general.TextDTO;
import com.app.FO.mapper.TagDTOMapper;
import com.app.FO.mapper.UserDTOMapper;
import com.app.FO.model.note.Note;
import com.app.FO.model.tag.Tag;
import com.app.FO.service.note.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tags")
public class TagController {
    private AllServices allServices;

    @Autowired
    public TagController(AllServices allServices) {
        this.allServices = allServices;
    }
    //-- GetMapping
    @GetMapping("/getAllTags")
    public List<TagDTO> getAllTagsDTO() {
        return allServices.getTagService().getAllTagsDTO();
    }

    //-- PostMapping
    //-- PutMapping
    //-- DeleteMapping
    //-- Converter

    public TagFDTO convertTagToTagFDTO(Tag tag) {
        return new TagFDTO(tag.getId(), tag.getTagName(),
                allServices.getNoteService().getNotesDTOByTagId(tag.getId()),
                allServices.getTopicService().getTopicsDTOByTagId(tag.getId())
        );
    }

    public List<TagFDTO> convertListOfNotesToListOfNotesFDTO(List<Tag> tags) {
        return tags.stream().map(this::convertTagToTagFDTO).collect(Collectors.toList());
    }
    //--- Other
//
//    @PostMapping("/addNewTag")
//    public TagDTO addNewTag(@RequestBody TextDTO tagText) {
//        return TagDTOMapper.INSTANCE.tagsToTagsDTO(tagService.saveTagFromText(tagText.getText()));
//    }
//
//    @PostMapping("/addNewTag1")
//    public TagFDTO addNewTag(@RequestBody TagDTO tagDTO) {
//        return converterDTO.convertTagToTagDTO(
//                tagService.saveTagFromText(tagDTO.getTag()));
//    }
//
//
//
//    @GetMapping("/getTagById/{tagId}")
//    public TagFDTO getTagById(@PathVariable Long tagId) {
//        return converterDTO.convertTagToTagDTO(tagService.getTagById(tagId));
//    }
//
//    @GetMapping("/getTagByName/{tagName}")
//    public List<TagFDTO> getTagByName(@PathVariable String tagName) {
//        return converterDTO.convertListOfTagToListOfTagDTO(
//                tagService.getTagsByName(tagName));
//    }
//
//    @GetMapping("/getTagByNoteId/{noteId}")
//    public List<TagFDTO> getTagByNoteId(@PathVariable Long noteId) {
//        return converterDTO.convertListOfTagToListOfTagDTO(
//                tagService.getListOfTagByNoteId(noteId));
//    }
//
//    @GetMapping("/getTagByTopicId/{topicId}")
//    public List<TagFDTO> getTagByTopicId(@PathVariable Long topicId) {
//        return converterDTO.convertListOfTagToListOfTagDTO(
//                tagService.getListOfTagByNoteId(topicId));
//    }

}
