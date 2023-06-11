package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.phoneNumber.PhoneNumberDTO;
import com.app.FO.mapper.mappers.PhoneNumberDTOMapper;
import com.app.FO.model.phoneNumber.PhoneNumber;
import com.app.FO.service.phoneNumber.PhoneNumberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phoneNumber")
public class PhoneNumberController {
    private PhoneNumberService phoneNumberService;

    private PhoneNumberDTOMapper phoneNumberDTOMapper;

    @Autowired
    public PhoneNumberController(PhoneNumberService phoneNumberService, PhoneNumberDTOMapper phoneNumberDTOMapper) {
        this.phoneNumberService = phoneNumberService;
        this.phoneNumberDTOMapper = phoneNumberDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewPhoneNumber")
    public PhoneNumberDTO postNewPhoneNumber(@RequestBody TextDTO noteText) {
        PhoneNumber phoneNumber = phoneNumberService.postPhoneNumber(noteText.getText());
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToPhoneNumber")
    public PhoneNumberDTO putSubjectToPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam String subject) {
        PhoneNumber phoneNumber = phoneNumberService.putSubjectToPhoneNumber(phoneNumberId, subject);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }


    //-- PutMapping
    @PutMapping("/putReferenceToPhoneNumber")
    public PhoneNumberDTO putReferenceToPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam String reference) {
        PhoneNumber phoneNumber = phoneNumberService.putReferenceToPhoneNumber(phoneNumberId, reference);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @PutMapping("/putUserToPhoneNumber")
    public PhoneNumberDTO putUserToPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam Long userId) {
        PhoneNumber phoneNumber = phoneNumberService.putUserToPhoneNumber(phoneNumberId, userId);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @PutMapping("/putTagToPhoneNumber")
    public PhoneNumberDTO putTagToPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam Long tagId) {
        PhoneNumber phoneNumber = phoneNumberService.putTagToPhoneNumber(phoneNumberId, tagId);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }


    @PutMapping("/putReminderToPhoneNumber")
    public PhoneNumberDTO putReminderToPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam Long reminderId) {
        PhoneNumber phoneNumber = phoneNumberService.putReminderToPhoneNumber(phoneNumberId, reminderId);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @PutMapping("/putTopicToPhoneNumber")
    public PhoneNumberDTO putTopicToPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam Long topicId) {
        PhoneNumber phoneNumber = phoneNumberService.putTopicToPhoneNumber(phoneNumberId, topicId);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @PutMapping("/putTasksToPhoneNumber")
    public PhoneNumberDTO putTasksToPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam Long tasksId) {
        PhoneNumber phoneNumber = phoneNumberService.putTasksToPhoneNumber(phoneNumberId, tasksId);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromPhoneNumber")
    public PhoneNumberDTO deleteRoleFromPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam Long userId) {
        PhoneNumber phoneNumber = phoneNumberService.deleteUserFromPhoneNumber(phoneNumberId, userId);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @DeleteMapping("/deleteTagFromPhoneNumber")
    public PhoneNumberDTO deleteTagFromPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam Long tagId) {
        PhoneNumber phoneNumber = phoneNumberService.deleteTagFromPhoneNumber(phoneNumberId, tagId);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @DeleteMapping("/deleteReminderFromPhoneNumber")
    public PhoneNumberDTO deleteReminderFromPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam Long reminderId) {
        PhoneNumber phoneNumber = phoneNumberService.deleteReminderFromPhoneNumber(phoneNumberId, reminderId);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }


    @DeleteMapping("/deleteTopicFromPhoneNumber")
    public PhoneNumberDTO deleteTopicFromPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam Long topicId) {
        PhoneNumber phoneNumber = phoneNumberService.deleteTopicFromPhoneNumber(phoneNumberId, topicId);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @DeleteMapping("/deleteTasksFromPhoneNumber")
    public PhoneNumberDTO deleteTasksFromPhoneNumber(@RequestParam Long phoneNumberId, @RequestParam Long tasksId) {
        PhoneNumber phoneNumber = phoneNumberService.deleteTasksFromPhoneNumber(phoneNumberId, tasksId);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @DeleteMapping("/deletePhoneNumber")
    public List<PhoneNumberDTO> deletePhoneNumber(@RequestParam Long phoneNumberId) {
        List<PhoneNumber> phoneNumberList = phoneNumberService.deletePhoneNumber(phoneNumberId);
        return phoneNumberDTOMapper.phoneNumberListToPhoneNumberDTOList(phoneNumberList);
    }


    //---GetMapping

    @GetMapping("/getAllPhoneNumber")
    public List<PhoneNumberDTO> getAllPhoneNumber() {
        List<PhoneNumber> phoneNumberList = phoneNumberService.getAllPhoneNumber();
        return phoneNumberDTOMapper.phoneNumberListToPhoneNumberDTOList(phoneNumberList);
    }

    @GetMapping("/getPhoneNumberById")
    public PhoneNumberDTO getPhoneNumberById(@RequestParam Long phoneNumberId) {
        PhoneNumber phoneNumber = phoneNumberService.getPhoneNumberByPhoneNumberId(phoneNumberId);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @GetMapping("/getPhoneNumberBySubject")
    public PhoneNumberDTO getPhoneNumberBySubject(@RequestParam String subject) {
        PhoneNumber phoneNumber = phoneNumberService.getPhoneNumberBySubject(subject);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @GetMapping("/getPhoneNumberListBySubjectContains")
    public List<PhoneNumberDTO> getPhoneNumberListBySubjectContains(@RequestParam String subjectContain) {
        List<PhoneNumber> phoneNumberList = phoneNumberService.getPhoneNumberListBySubjectContains(subjectContain);
        return phoneNumberDTOMapper.phoneNumberListToPhoneNumberDTOList(phoneNumberList);
    }

    @GetMapping("/getPhoneNumberByReference")
    public PhoneNumberDTO getPhoneNumberByReference(@RequestParam String reference) {
        PhoneNumber phoneNumber = phoneNumberService.getPhoneNumberByReference(reference);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @GetMapping("/getPhoneNumberListByReferenceContains")
    public List<PhoneNumberDTO> getPhoneNumberListByReferenceContains(@RequestParam String referenceContain) {
        List<PhoneNumber> phoneNumberList = phoneNumberService.getPhoneNumberListByReferenceContains(referenceContain);
        return phoneNumberDTOMapper.phoneNumberListToPhoneNumberDTOList(phoneNumberList);
    }

    @GetMapping("/getPhoneNumberByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public PhoneNumberDTO getPhoneNumberByCreatedDate(@RequestParam String createdDate) {
        PhoneNumber phoneNumber = phoneNumberService.getPhoneNumberByCreatedDate(createdDate);
        return phoneNumberDTOMapper.phoneNumberToPhoneNumberDTO(phoneNumber);
    }

    @GetMapping("/getPhoneNumberListByCreatedDateBetween")
    public List<PhoneNumberDTO> getPhoneNumberListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<PhoneNumber> phoneNumberList = phoneNumberService.getPhoneNumberListByCreatedDateBetween(createdDateMin, createdDateMax);
        return phoneNumberDTOMapper.phoneNumberListToPhoneNumberDTOList(phoneNumberList);
    }

    @GetMapping("/getPhoneNumberListByUserId")
    public List<PhoneNumberDTO> getPhoneNumberListByUserId(@RequestParam Long userId) {
        List<PhoneNumber> phoneNumberList = phoneNumberService.getPhoneNumberListByUserId(userId);
        return phoneNumberDTOMapper.phoneNumberListToPhoneNumberDTOList(phoneNumberList);
    }

    @GetMapping("/getPhoneNumberListByTagId")
    public List<PhoneNumberDTO> getPhoneNumberListByTagId(@RequestParam Long tagId) {
        List<PhoneNumber> phoneNumberList = phoneNumberService.getPhoneNumberListByTagId(tagId);
        return phoneNumberDTOMapper.phoneNumberListToPhoneNumberDTOList(phoneNumberList);
    }

    @GetMapping("/getPhoneNumberListByReminderId")
    public List<PhoneNumberDTO> getPhoneNumberListByReminderId(@RequestParam Long reminderId) {
        List<PhoneNumber> phoneNumberList = phoneNumberService.getPhoneNumberListByReminderId(reminderId);
        return phoneNumberDTOMapper.phoneNumberListToPhoneNumberDTOList(phoneNumberList);
    }

    @GetMapping("/getPhoneNumberListByTopicId")
    public List<PhoneNumberDTO> getPhoneNumberListByTopicId(@RequestParam Long topicId) {
        List<PhoneNumber> phoneNumberList = phoneNumberService.getPhoneNumberListByTopicId(topicId);
        return phoneNumberDTOMapper.phoneNumberListToPhoneNumberDTOList(phoneNumberList);
    }

    @GetMapping("/getPhoneNumberListByTasksId")
    public List<PhoneNumberDTO> getPhoneNumberListByTasksId(@RequestParam Long tasksId) {
        List<PhoneNumber> phoneNumberList = phoneNumberService.getPhoneNumberListByTasksId(tasksId);
        return phoneNumberDTOMapper.phoneNumberListToPhoneNumberDTOList(phoneNumberList);
    }


    //--- Other


}
