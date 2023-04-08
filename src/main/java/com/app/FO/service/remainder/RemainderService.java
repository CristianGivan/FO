package com.app.FO.service.remainder;

import com.app.FO.model.remainder.Remainder;
import com.app.FO.repository.remainder.RemainderRepository;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemainderService {
   private RemainderRepository remainderRepository;
   @Autowired
   private UserService userService;

   @Autowired
   public RemainderService(RemainderRepository remainderRepository) {
      this.remainderRepository = remainderRepository;
   }
   //-- Post

   public Remainder postRemainder(Remainder remainder){
      return remainderRepository.save(remainder);
   }
   public Remainder postRemainderText(String remainderText){
      return remainderRepository.save(new Remainder(remainderText,userService.getLogInUser()));
   }
   //-- GET

   public List<Remainder> getAllRemainder(){
      return remainderRepository.getRemainderListByUserId(userService.getLogInUser().getId());
   }

   public Remainder getRemainderByRemainderIdFromUser(Long remainderId){
      return remainderRepository.getRemainderByRemainderIdFromUser(remainderId,userService.getLogInUser().getId());
   }



   //-- Put



   //--Delete



   //-- Checks




   //-- Other


}
