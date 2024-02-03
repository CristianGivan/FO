package com.app.FO.controller;

import com.app.FO.mapper.dto.reminder.ReminderDTO;
import com.app.FO.mapper.mappers.ReminderDTOMapper;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.service.reminder.ReminderService;
import io.swagger.annotations.ApiOperation;
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


    //-- PostMapping

    @PostMapping("/postNewReminder")
    public ReminderDTO postNewReminder(@RequestParam String subject) {
        Reminder reminder = reminderService.postReminder(subject);
        return reminderDTOMapper.reminderToReminderDTO(reminder);

    }


    //-- PutMapping
    @PutMapping("/putSubjectToReminder")
    public ReminderDTO putSubjectToReminder(@RequestParam Long reminderId, @RequestParam String subject) {
        Reminder reminder = reminderService.putSubjectToReminder(reminderId, subject);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }

    @PutMapping("/putReminderDateToReminder")
    public ReminderDTO putReminderDateToReminder(@RequestParam Long reminderId, @RequestParam String reminderDateTime) {
        Reminder reminder = reminderService.putReminderDateToReminder(reminderId, reminderDateTime);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }

    @PutMapping("/putUserToReminder")
    public ReminderDTO putUserToReminder(@RequestParam Long reminderId, @RequestParam Long userId) {
        Reminder reminder = reminderService.putUserToReminder(reminderId, userId);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }

    @PutMapping("/putSnoozeToReminder")
    public ReminderDTO putSnoozeToReminder(@RequestParam Long reminderId, @RequestParam Long snoozeId) {
        Reminder reminder = reminderService.putSnoozeToReminder(reminderId, snoozeId);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }

    @PutMapping("/putReminderToReminder")
    public ReminderDTO putReminderToReminder(@RequestParam Long reminderId, @RequestParam Long repeatedReminder) {
        Reminder reminder = reminderService.putReminderToReminder(reminderId, repeatedReminder);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromReminder")
    public ReminderDTO deleteUserFromReminder(@RequestParam Long reminderId, @RequestParam Long userId) {
        Reminder reminder = reminderService.deleteUserFromReminder(reminderId, userId);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }

    @DeleteMapping("/deleteSnoozeFromReminder")
    public ReminderDTO deleteSnoozeFromReminder(@RequestParam Long reminderId, @RequestParam Long snoozeId) {
        Reminder reminder = reminderService.deleteSnoozeFromReminder(reminderId, snoozeId);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }

    @DeleteMapping("/deleteReminderFromReminder")
    public ReminderDTO deleteReminderFromReminder(@RequestParam Long reminderId, @RequestParam Long repeatedReminder) {
        Reminder reminder = reminderService.deleteReminderFromReminder(reminderId, repeatedReminder);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }

    @DeleteMapping("/deleteReminder")
    public List<ReminderDTO> deleteReminder(@RequestParam Long reminderId) {
        List<Reminder> reminderList = reminderService.deleteReminder(reminderId);
        return reminderDTOMapper.reminderListToReminderDTOList(reminderList);
    }


    //---GetMapping

    @GetMapping("/getAllReminder")
    public List<ReminderDTO> getAllReminder() {
        List<Reminder> reminderList = reminderService.getAllReminder();
        return reminderDTOMapper.reminderListToReminderDTOList(reminderList);
    }


    @GetMapping("/getReminderById")
    public ReminderDTO getReminderById(@RequestParam Long reminderId) {
        Reminder reminder = reminderService.getReminderByReminderId(reminderId);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }

    @GetMapping("/getReminderBySubject")
    public ReminderDTO getReminderBySubject(@RequestParam String subject) {
        Reminder reminder = reminderService.getReminderBySubject(subject);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }

    @GetMapping("/getReminderListBySubjectContains")
    public List<ReminderDTO> getReminderListBySubjectContains(@RequestParam String subjectContain) {
        List<Reminder> reminderList = reminderService.getReminderListBySubjectContains(subjectContain);
        return reminderDTOMapper.reminderListToReminderDTOList(reminderList);
    }

    @GetMapping("/getReminderByReminderDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public ReminderDTO getReminderByReminderDate(@RequestParam String reminderDate) {
        Reminder reminder = reminderService.getReminderByReminderDate(reminderDate);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }

    @GetMapping("/getReminderListByReminderDateBetween")
    public List<ReminderDTO> getReminderListByReminderDateBetween(@RequestParam String reminderDateTimeMin, @RequestParam String reminderDateTimeMax) {
        List<Reminder> reminderList = reminderService.getReminderListByReminderDateBetween(reminderDateTimeMin, reminderDateTimeMax);
        return reminderDTOMapper.reminderListToReminderDTOList(reminderList);
    }

    @GetMapping("/getReminderByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public ReminderDTO getReminderByCreatedDate(@RequestParam String createdDate) {
        Reminder reminder = reminderService.getReminderByCreatedDate(createdDate);
        return reminderDTOMapper.reminderToReminderDTO(reminder);
    }

    @GetMapping("/getReminderListByCreatedDateBetween")
    public List<ReminderDTO> getReminderListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Reminder> reminderList = reminderService.getReminderListByCreatedDateBetween(createdDateMin, createdDateMax);
        return reminderDTOMapper.reminderListToReminderDTOList(reminderList);
    }

    @GetMapping("/getReminderListByUserId")
    public List<ReminderDTO> getReminderListByUserId(@RequestParam Long userId) {
        List<Reminder> reminderList = reminderService.getReminderListByUserId(userId);
        return reminderDTOMapper.reminderListToReminderDTOList(reminderList);
    }

    @GetMapping("/getReminderListBySnoozeId")
    public List<ReminderDTO> getReminderListBySnoozeId(@RequestParam Long snoozeId) {
        List<Reminder> reminderList = reminderService.getReminderListBySnoozeId(snoozeId);
        return reminderDTOMapper.reminderListToReminderDTOList(reminderList);
    }


    @GetMapping("/getReminderListWithReminder")
    public List<ReminderDTO> getReminderListWithReminder(@RequestParam Long reminderId) {
        List<Reminder> reminderList = reminderService.getReminderListWithReminder(reminderId);
        return reminderDTOMapper.reminderListToReminderDTOList(reminderList);
    }

    @GetMapping("/getReminderListFromReminder")
    public List<ReminderDTO> getReminderListFromReminder(@RequestParam Long reminderId) {
        List<Reminder> reminderList = reminderService.getReminderListFromReminder(reminderId);
        return reminderDTOMapper.reminderListToReminderDTOList(reminderList);
    }

    //--- Other


}
