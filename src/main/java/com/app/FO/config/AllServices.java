package com.app.FO.config;

import com.app.FO.model.tag.Tag;
import com.app.FO.model.user.User;
import com.app.FO.service.tag.TagService;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AllServices {
    /*
     * I decided to use this class as a workaround because:
     * after inserting to many services in Note and Tag mapper I receive spring.main.allow-circular-references if I uncomment note service
     * */

    private UserService userService;

    private TagService tagService;

//    @Autowired
//    private UserDTOMapper userDTOMapper;

    @Autowired
    public AllServices(UserService userService) {
        this.userService = userService;
    }
//
//    public List<User> getUserListDTOByTag(Tag tag) {
//        return userService.getUserListByTagId(tag.getId());
//    }

    public List<User> getUserListDTOByUser(User user) {
        return userService.getUserListByUserId(user.getId());
    }

    public List<Tag> getTagListDTOByUser(User user) {
        return tagService.getTagListByUserId(user.getId());
    }

}
