package com.app.FO.controller.note;

import com.app.FO.dto.tag.TagDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/1")
    public String getTagById(@PathVariable Long tagId) {
        String testString ="test1";
        return testString;
    }
}
