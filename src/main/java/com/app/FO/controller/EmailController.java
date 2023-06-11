package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.email.EmailDTO;
import com.app.FO.mapper.mappers.EmailDTOMapper;
import com.app.FO.model.email.Email;
import com.app.FO.service.email.EmailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("email")
public class EmailController {
    private EmailService emailService;

    private EmailDTOMapper emailDTOMapper;

    @Autowired
    public EmailController(EmailService emailService, EmailDTOMapper emailDTOMapper) {
        this.emailService = emailService;
        this.emailDTOMapper = emailDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewEmail")
    public EmailDTO postNewEmail(@RequestBody TextDTO noteText) {
        Email email = emailService.postEmail(noteText.getText());
        return emailDTOMapper.emailToEmailDTO(email);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToEmail")
    public EmailDTO putSubjectToEmail(@RequestParam Long emailId, @RequestParam String subject) {
        Email email = emailService.putSubjectToEmail(emailId, subject);
        return emailDTOMapper.emailToEmailDTO(email);
    }


    //-- PutMapping
    @PutMapping("/putReferenceToEmail")
    public EmailDTO putReferenceToEmail(@RequestParam Long emailId, @RequestParam String reference) {
        Email email = emailService.putReferenceToEmail(emailId, reference);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @PutMapping("/putUserToEmail")
    public EmailDTO putUserToEmail(@RequestParam Long emailId, @RequestParam Long userId) {
        Email email = emailService.putUserToEmail(emailId, userId);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @PutMapping("/putTagToEmail")
    public EmailDTO putTagToEmail(@RequestParam Long emailId, @RequestParam Long tagId) {
        Email email = emailService.putTagToEmail(emailId, tagId);
        return emailDTOMapper.emailToEmailDTO(email);
    }


    @PutMapping("/putReminderToEmail")
    public EmailDTO putReminderToEmail(@RequestParam Long emailId, @RequestParam Long reminderId) {
        Email email = emailService.putReminderToEmail(emailId, reminderId);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @PutMapping("/putTopicToEmail")
    public EmailDTO putTopicToEmail(@RequestParam Long emailId, @RequestParam Long topicId) {
        Email email = emailService.putTopicToEmail(emailId, topicId);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @PutMapping("/putTasksToEmail")
    public EmailDTO putTasksToEmail(@RequestParam Long emailId, @RequestParam Long tasksId) {
        Email email = emailService.putTasksToEmail(emailId, tasksId);
        return emailDTOMapper.emailToEmailDTO(email);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromEmail")
    public EmailDTO deleteRoleFromEmail(@RequestParam Long emailId, @RequestParam Long userId) {
        Email email = emailService.deleteUserFromEmail(emailId, userId);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @DeleteMapping("/deleteTagFromEmail")
    public EmailDTO deleteTagFromEmail(@RequestParam Long emailId, @RequestParam Long tagId) {
        Email email = emailService.deleteTagFromEmail(emailId, tagId);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @DeleteMapping("/deleteReminderFromEmail")
    public EmailDTO deleteReminderFromEmail(@RequestParam Long emailId, @RequestParam Long reminderId) {
        Email email = emailService.deleteReminderFromEmail(emailId, reminderId);
        return emailDTOMapper.emailToEmailDTO(email);
    }


    @DeleteMapping("/deleteTopicFromEmail")
    public EmailDTO deleteTopicFromEmail(@RequestParam Long emailId, @RequestParam Long topicId) {
        Email email = emailService.deleteTopicFromEmail(emailId, topicId);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @DeleteMapping("/deleteTasksFromEmail")
    public EmailDTO deleteTasksFromEmail(@RequestParam Long emailId, @RequestParam Long tasksId) {
        Email email = emailService.deleteTasksFromEmail(emailId, tasksId);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @DeleteMapping("/deleteEmail")
    public List<EmailDTO> deleteEmail(@RequestParam Long emailId) {
        List<Email> emailList = emailService.deleteEmail(emailId);
        return emailDTOMapper.emailListToEmailDTOList(emailList);
    }


    //---GetMapping

    @GetMapping("/getAllEmail")
    public List<EmailDTO> getAllEmail() {
        List<Email> emailList = emailService.getAllEmail();
        return emailDTOMapper.emailListToEmailDTOList(emailList);
    }

    @GetMapping("/getEmailById")
    public EmailDTO getEmailById(@RequestParam Long emailId) {
        Email email = emailService.getEmailByEmailId(emailId);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @GetMapping("/getEmailBySubject")
    public EmailDTO getEmailBySubject(@RequestParam String subject) {
        Email email = emailService.getEmailBySubject(subject);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @GetMapping("/getEmailListBySubjectContains")
    public List<EmailDTO> getEmailListBySubjectContains(@RequestParam String subjectContain) {
        List<Email> emailList = emailService.getEmailListBySubjectContains(subjectContain);
        return emailDTOMapper.emailListToEmailDTOList(emailList);
    }

    @GetMapping("/getEmailByReference")
    public EmailDTO getEmailByReference(@RequestParam String reference) {
        Email email = emailService.getEmailByReference(reference);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @GetMapping("/getEmailListByReferenceContains")
    public List<EmailDTO> getEmailListByReferenceContains(@RequestParam String referenceContain) {
        List<Email> emailList = emailService.getEmailListByReferenceContains(referenceContain);
        return emailDTOMapper.emailListToEmailDTOList(emailList);
    }

    @GetMapping("/getEmailByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public EmailDTO getEmailByCreatedDate(@RequestParam String createdDate) {
        Email email = emailService.getEmailByCreatedDate(createdDate);
        return emailDTOMapper.emailToEmailDTO(email);
    }

    @GetMapping("/getEmailListByCreatedDateBetween")
    public List<EmailDTO> getEmailListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Email> emailList = emailService.getEmailListByCreatedDateBetween(createdDateMin, createdDateMax);
        return emailDTOMapper.emailListToEmailDTOList(emailList);
    }

    @GetMapping("/getEmailListByUserId")
    public List<EmailDTO> getEmailListByUserId(@RequestParam Long userId) {
        List<Email> emailList = emailService.getEmailListByUserId(userId);
        return emailDTOMapper.emailListToEmailDTOList(emailList);
    }

    @GetMapping("/getEmailListByTagId")
    public List<EmailDTO> getEmailListByTagId(@RequestParam Long tagId) {
        List<Email> emailList = emailService.getEmailListByTagId(tagId);
        return emailDTOMapper.emailListToEmailDTOList(emailList);
    }

    @GetMapping("/getEmailListByReminderId")
    public List<EmailDTO> getEmailListByReminderId(@RequestParam Long reminderId) {
        List<Email> emailList = emailService.getEmailListByReminderId(reminderId);
        return emailDTOMapper.emailListToEmailDTOList(emailList);
    }

    @GetMapping("/getEmailListByTopicId")
    public List<EmailDTO> getEmailListByTopicId(@RequestParam Long topicId) {
        List<Email> emailList = emailService.getEmailListByTopicId(topicId);
        return emailDTOMapper.emailListToEmailDTOList(emailList);
    }

    @GetMapping("/getEmailListByTasksId")
    public List<EmailDTO> getEmailListByTasksId(@RequestParam Long tasksId) {
        List<Email> emailList = emailService.getEmailListByTasksId(tasksId);
        return emailDTOMapper.emailListToEmailDTOList(emailList);
    }


    //--- Other


}
