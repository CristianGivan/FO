package com.app.FO.config;

import com.app.FO.mapper.dto.user.UserDTO;
import com.app.FO.mapper.mappers.UserDTOMapper;
import com.app.FO.model.tag.Tag;
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

    public UserService userService;
    public UserDTOMapper userDTOMapper;

    @Autowired
    public AllServices(UserService userService, UserDTOMapper userDTOMapper) {
        this.userService = userService;
        this.userDTOMapper = userDTOMapper;
    }

    public List<UserDTO> getUserListDTOByTag(Tag tag) {
        return userDTOMapper.UserListToUserDTOList(userService.getUserListByTagId(tag.getId()));
    }

}
