package com.app.FO.service.remainder;

import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagFDTO;
import com.app.FO.exceptions.TagAlreadyExistException;
import com.app.FO.exceptions.TagNotFoundException;
import com.app.FO.mapper.TagDTOMapper;
import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserTag;
import com.app.FO.repository.remainder.RemainderRepository;
import com.app.FO.repository.tag.TagRepository;
import com.app.FO.service.user.UserService;
import com.app.FO.service.user.UserTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemainderService {
   private RemainderRepository remainderRepository;

   public RemainderService(RemainderRepository remainderRepository) {
      this.remainderRepository = remainderRepository;
   }
   //-- GET



   //-- Post


   //-- Put



   //--Delete



   //-- Checks




   //-- Other


}
