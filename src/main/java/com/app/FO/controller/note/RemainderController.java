package com.app.FO.controller.note;

import com.app.FO.dto.general.TextDTO;
import com.app.FO.dto.remainder.RemainderDTO;
import com.app.FO.exceptions.RemainderNotFoundException;
import com.app.FO.mapper.ReminderDTOMapper;
import com.app.FO.model.remainder.Remainder;
import com.app.FO.service.remainder.RemainderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remainder")
public class RemainderController {

    private RemainderService remainderService;
    private ReminderDTOMapper reminderDTOMapper;

    @Autowired
    public RemainderController(RemainderService remainderService, ReminderDTOMapper reminderDTOMapper) {
        this.remainderService = remainderService;
        this.reminderDTOMapper = reminderDTOMapper;
    }



    //-- PutMapping

    @PostMapping("/addNewRemainder")
    public RemainderDTO PostNewNote(@RequestBody TextDTO remainderText) {
        Remainder remainder =remainderService.postRemainderText(remainderText.getText());
        return reminderDTOMapper.RemainderTORemainderDTO(remainder);
    }

    // -- GetMapping
    @GetMapping("/getAllRemainder")
    public List<RemainderDTO> getAllRemainder() {
        List<Remainder> remainderList = remainderService.getAllRemainder();
        return reminderDTOMapper.RemainderListTORemainderDTOList(remainderList);
    }

    @GetMapping("/getRemainderByRemainderId/{remainderId}")
    public RemainderDTO getRemainderByRemainderIdFromUser(@PathVariable Long remainderId) {
        Remainder remainder =remainderService.getRemainderByRemainderIdFromUser(remainderId);

        if (remainder == null) {
            throw new RemainderNotFoundException("The remainder was not found");
        }
        return reminderDTOMapper.RemainderTORemainderDTO(remainder);
    }

    //-- PostMapping


    //-- DeleteMapping


    //--- Other

}
