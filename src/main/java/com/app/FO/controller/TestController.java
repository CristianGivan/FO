package com.app.FO.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/1")
    public String test1() {
        String testString = "test1";
        return testString;
    }

    @GetMapping("/2")
    public String test2() {
        String testString = "test2";
        return testString;
    }
}
