package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.reminder.ReminderDTO;
import com.app.FO.mapper.mappers.ReminderDTOMapper;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.service.reminder.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminder")
public class ReminderController {

    private ReminderService reminderService;
    private ReminderDTOMapper reminderDTOMapper;

    @Autowired
    public ReminderController(ReminderService reminderService, ReminderDTOMapper reminderDTOMapper) {
        this.reminderService = reminderService;
        this.reminderDTOMapper = reminderDTOMapper;
    }


    //-- PutMapping

    @PostMapping("/addNewReminder")
    public ReminderDTO PostNewNote(@RequestBody TextDTO reminderText) {
        Reminder reminder = reminderService.postReminderText(reminderText.getText());
        return reminderDTOMapper.ReminderTOReminderDTO(reminder);
    }

    // -- GetMapping
    @GetMapping("/getAllReminder")
    public List<ReminderDTO> getAllReminder() {
        List<Reminder> reminderList = reminderService.getAllReminder();
        return reminderDTOMapper.ReminderListTOReminderDTOList(reminderList);
    }

    @GetMapping("/getReminderByReminderId/{reminderId}")
    public ReminderDTO getReminderByReminderIdFromUser(@PathVariable Long reminderId) {
        Reminder reminder = reminderService.getReminderByReminderIdFromUser(reminderId);
        return reminderDTOMapper.ReminderTOReminderDTO(reminder);
    }

    @GetMapping("/getReminderListByNoteId/{noteId}")
    public List<ReminderDTO> getReminderListByNoteId(@PathVariable Long noteId) {
        List<Reminder> reminderList = reminderService.getReminderListByNoteId(noteId);
        return reminderDTOMapper.ReminderListTOReminderDTOList(reminderList);
    }

    //-- PostMapping


    //-- DeleteMapping
    @DeleteMapping("/deleteReminderById")
    public void deleteReminderById(@RequestParam Long reminderId) {
        reminderService.deleteReminderById(reminderId);
    }

    //--- Other

}
