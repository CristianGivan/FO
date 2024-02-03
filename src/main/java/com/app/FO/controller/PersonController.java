package com.app.FO.controller;

import com.app.FO.mapper.dto.person.PersonDTO;
import com.app.FO.mapper.mappers.PersonDTOMapper;
import com.app.FO.model.person.Person;
import com.app.FO.service.person.PersonService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {
    private PersonService personService;

    private PersonDTOMapper personDTOMapper;

    @Autowired
    public PersonController(PersonService personService, PersonDTOMapper personDTOMapper) {
        this.personService = personService;
        this.personDTOMapper = personDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewPerson")
    public PersonDTO postNewPerson(@RequestParam String nickName, @RequestParam String description) {
        Person person = personService.postPerson(nickName, description);
        return personDTOMapper.personToPersonDTO(person);
    }


    //-- PutMapping
    @PutMapping("/putNickNameToPerson")
    public PersonDTO putNickNameToPerson(@RequestParam Long personId, @RequestParam String subject) {
        Person person = personService.putNickNameToPerson(personId, subject);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putFirstNameToPerson")
    public PersonDTO putFirstNameToPerson(@RequestParam Long personId, @RequestParam String subject) {
        Person person = personService.putFirstNameToPerson(personId, subject);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putMiddleNameToPerson")
    public PersonDTO putMiddleNameToPerson(@RequestParam Long personId, @RequestParam String subject) {
        Person person = personService.putMiddleNameToPerson(personId, subject);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putLastNameToPerson")
    public PersonDTO putLastNameToPerson(@RequestParam Long personId, @RequestParam String subject) {
        Person person = personService.putLastNameToPerson(personId, subject);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putDescriptionToPerson")
    public PersonDTO putDescriptionToPerson(@RequestParam Long personId, @RequestParam String subject) {
        Person person = personService.putDescriptionToPerson(personId, subject);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putSubjectToPerson")
    public PersonDTO putSubjectToPerson(@RequestParam Long personId, @RequestParam String subject) {
        Person person = personService.putSubjectToPerson(personId, subject);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putUserToPerson")
    public PersonDTO putUserToPerson(@RequestParam Long personId, @RequestParam Long userId) {
        Person person = personService.putUserToPerson(personId, userId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putTagToPerson")
    public PersonDTO putTagToPerson(@RequestParam Long personId, @RequestParam Long tagId) {
        Person person = personService.putTagToPerson(personId, tagId);
        return personDTOMapper.personToPersonDTO(person);
    }


    @PutMapping("/putReminderToPerson")
    public PersonDTO putReminderToPerson(@RequestParam Long personId, @RequestParam Long reminderId) {
        Person person = personService.putReminderToPerson(personId, reminderId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putTopicToPerson")
    public PersonDTO putTopicToPerson(@RequestParam Long personId, @RequestParam Long topicId) {
        Person person = personService.putTopicToPerson(personId, topicId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putTasksToPerson")
    public PersonDTO putTasksToPerson(@RequestParam Long personId, @RequestParam Long tasksId) {
        Person person = personService.putTasksToPerson(personId, tasksId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putDocumentToPerson")
    public PersonDTO putDocumentToPerson(@RequestParam Long personId, @RequestParam Long documentId) {
        Person person = personService.putDocumentToPerson(personId, documentId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putAddressToPerson")
    public PersonDTO putAddressToPerson(@RequestParam Long personId, @RequestParam Long addressId) {
        Person person = personService.putAddressToPerson(personId, addressId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putEmailToPerson")
    public PersonDTO putEmailToPerson(@RequestParam Long personId, @RequestParam Long emailId) {
        Person person = personService.putEmailToPerson(personId, emailId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putPhoneNumberToPerson")
    public PersonDTO putPhoneNumberToPerson(@RequestParam Long personId, @RequestParam Long phoneNumberId) {
        Person person = personService.putPhoneNumberToPerson(personId, phoneNumberId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @PutMapping("/putDatesToPerson")
    public PersonDTO putDatesToPerson(@RequestParam Long personId, @RequestParam Long datesId) {
        Person person = personService.putDatesToPerson(personId, datesId);
        return personDTOMapper.personToPersonDTO(person);
    }


    @PutMapping("/putPersonToPerson")
    public PersonDTO putPersonToPerson(@RequestParam Long personId, @RequestParam Long relatedPersonId) {
        Person person = personService.putPersonToPerson(personId, relatedPersonId);
        return personDTOMapper.personToPersonDTO(person);
    }

    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromPerson")
    public PersonDTO deleteRoleFromPerson(@RequestParam Long personId, @RequestParam Long userId) {
        Person person = personService.deleteUserFromPerson(personId, userId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @DeleteMapping("/deleteTagFromPerson")
    public PersonDTO deleteTagFromPerson(@RequestParam Long personId, @RequestParam Long tagId) {
        Person person = personService.deleteTagFromPerson(personId, tagId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @DeleteMapping("/deleteReminderFromPerson")
    public PersonDTO deleteReminderFromPerson(@RequestParam Long personId, @RequestParam Long reminderId) {
        Person person = personService.deleteReminderFromPerson(personId, reminderId);
        return personDTOMapper.personToPersonDTO(person);
    }


    @DeleteMapping("/deleteTopicFromPerson")
    public PersonDTO deleteTopicFromPerson(@RequestParam Long personId, @RequestParam Long topicId) {
        Person person = personService.deleteTopicFromPerson(personId, topicId);
        return personDTOMapper.personToPersonDTO(person);
    }


    @DeleteMapping("/deleteTasksFromPerson")
    public PersonDTO deleteTasksFromPerson(@RequestParam Long personId, @RequestParam Long tasksId) {
        Person person = personService.deleteTasksFromPerson(personId, tasksId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @DeleteMapping("/deleteDocumentFromPerson")
    public PersonDTO deleteDocumentFromPerson(@RequestParam Long personId, @RequestParam Long tasksId) {
        Person person = personService.deleteDocumentFromPerson(personId, tasksId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @DeleteMapping("/deleteAddressFromPerson")
    public PersonDTO deleteAddressFromPerson(@RequestParam Long personId, @RequestParam Long addressId) {
        Person person = personService.deleteAddressFromPerson(personId, addressId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @DeleteMapping("/deleteEmailFromPerson")
    public PersonDTO deleteEmailFromPerson(@RequestParam Long personId, @RequestParam Long emailId) {
        Person person = personService.deleteEmailFromPerson(personId, emailId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @DeleteMapping("/deletePhoneNumberFromPerson")
    public PersonDTO deletePhoneNumberFromPerson(@RequestParam Long personId, @RequestParam Long phoneNumberId) {
        Person person = personService.deletePhoneNumberFromPerson(personId, phoneNumberId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @DeleteMapping("/deleteDatesFromPerson")
    public PersonDTO deleteDatesFromPerson(@RequestParam Long personId, @RequestParam Long datesId) {
        Person person = personService.deleteDatesFromPerson(personId, datesId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @DeleteMapping("/deletePersonFromPerson")
    public PersonDTO deletePersonFromPerson(@RequestParam Long personId, @RequestParam Long releatedPersonId) {
        Person person = personService.deletePersonFromPerson(personId, releatedPersonId);
        return personDTOMapper.personToPersonDTO(person);
    }


    @DeleteMapping("/deletePerson")
    public List<PersonDTO> deletePerson(@RequestParam Long personId) {
        List<Person> personList = personService.deletePerson(personId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }


    //---GetMapping

    @GetMapping("/getAllPerson")
    public List<PersonDTO> getAllPerson() {
        List<Person> personList = personService.getAllPerson();
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonById")
    public PersonDTO getPersonById(@RequestParam Long personId) {
        Person person = personService.getPersonByPersonId(personId);
        return personDTOMapper.personToPersonDTO(person);
    }

    @GetMapping("/getPersonListByNickName")
    public List<PersonDTO> getPersonListByNickName(@RequestParam String subject) {
        List<Person> personList = personService.getPersonListByNickName(subject);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByNickNameContains")
    public List<PersonDTO> getPersonListByNickNameContains(@RequestParam String subjectContain) {
        List<Person> personList = personService.getPersonListByNickNameContains(subjectContain);
        return personDTOMapper.personListToPersonDTOList(personList);
    }


    @GetMapping("/getPersonListByFirstName")
    public List<PersonDTO> getPersonListByFirstName(@RequestParam String subject) {
        List<Person> personList = personService.getPersonListByFirstName(subject);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByFirstNameContains")
    public List<PersonDTO> getPersonListByFirstNameContains(@RequestParam String subjectContain) {
        List<Person> personList = personService.getPersonListByFirstNameContains(subjectContain);
        return personDTOMapper.personListToPersonDTOList(personList);
    }


    @GetMapping("/getPersonListByMiddleName")
    public List<PersonDTO> getPersonListByMiddleName(@RequestParam String subject) {
        List<Person> personList = personService.getPersonListByMiddleName(subject);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByMiddleNameContains")
    public List<PersonDTO> getPersonListByMiddleNameContains(@RequestParam String subjectContain) {
        List<Person> personList = personService.getPersonListByMiddleNameContains(subjectContain);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByLastName")
    public List<PersonDTO> getPersonListByLastName(@RequestParam String subject) {
        List<Person> personList = personService.getPersonListByLastName(subject);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByLastNameContains")
    public List<PersonDTO> getPersonListByLastNameContains(@RequestParam String subjectContain) {
        List<Person> personList = personService.getPersonListByLastNameContains(subjectContain);
        return personDTOMapper.personListToPersonDTOList(personList);
    }


    @GetMapping("/getPersonListByFullName")
    public List<PersonDTO> getPersonListByFullName(@RequestParam String subject) {
        List<Person> personList = personService.getPersonListByFullName(subject);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByFullNameContains")
    public List<PersonDTO> getPersonListByFullNameContains(@RequestParam String subjectContain) {
        List<Person> personList = personService.getPersonListByFullNameContains(subjectContain);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByDescription")
    public List<PersonDTO> getPersonListByDescription(@RequestParam String description) {
        List<Person> personList = personService.getPersonListByDescription(description);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByDescriptionContains")
    public List<PersonDTO> getPersonListByDescriptionContains(@RequestParam String descriptionContain) {
        List<Person> personList = personService.getPersonListByDescriptionContains(descriptionContain);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonBySubject")
    public PersonDTO getPersonBySubject(@RequestParam String subject) {
        Person person = personService.getPersonBySubject(subject);
        return personDTOMapper.personToPersonDTO(person);
    }

    @GetMapping("/getPersonListBySubjectContains")
    public List<PersonDTO> getPersonListBySubjectContains(@RequestParam String subjectContain) {
        List<Person> personList = personService.getPersonListBySubjectContains(subjectContain);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public PersonDTO getPersonByCreatedDate(@RequestParam String createdDate) {
        Person person = personService.getPersonByCreatedDate(createdDate);
        return personDTOMapper.personToPersonDTO(person);
    }

    @GetMapping("/getPersonListByCreatedDateBetween")
    public List<PersonDTO> getPersonListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Person> personList = personService.getPersonListByCreatedDateBetween(createdDateMin, createdDateMax);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByUserId")
    public List<PersonDTO> getPersonListByUserId(@RequestParam Long userId) {
        List<Person> personList = personService.getPersonListByUserId(userId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByTagId")
    public List<PersonDTO> getPersonListByTagId(@RequestParam Long tagId) {
        List<Person> personList = personService.getPersonListByTagId(tagId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByReminderId")
    public List<PersonDTO> getPersonListByReminderId(@RequestParam Long reminderId) {
        List<Person> personList = personService.getPersonListByReminderId(reminderId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByTopicId")
    public List<PersonDTO> getPersonListByTopicId(@RequestParam Long topicId) {
        List<Person> personList = personService.getPersonListByTopicId(topicId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByTasksId")
    public List<PersonDTO> getPersonListByTasksId(@RequestParam Long tasksId) {
        List<Person> personList = personService.getPersonListByTasksId(tasksId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByDocument")
    public List<PersonDTO> getPersonListByDocument(@RequestParam Long documentId) {
        List<Person> personList = personService.getPersonListByDocument(documentId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByAddress")
    public List<PersonDTO> getPersonListByAddress(@RequestParam Long addressId) {
        List<Person> personList = personService.getPersonListByAddress(addressId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByEmail")
    public List<PersonDTO> getPersonListByEmail(@RequestParam Long emailId) {
        List<Person> personList = personService.getPersonListByEmail(emailId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByPhoneNumberId")
    public List<PersonDTO> getPersonListByPhoneNumberId(@RequestParam Long phoneNumberId) {
        List<Person> personList = personService.getPersonListByPhoneNumberId(phoneNumberId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByDatesId")
    public List<PersonDTO> getPersonListByDatesId(@RequestParam Long datesId) {
        List<Person> personList = personService.getPersonListByDatesId(datesId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }

    @GetMapping("/getPersonListByExpenses")
    public List<PersonDTO> getPersonListByExpenses(@RequestParam Long tasksId) {
        List<Person> personList = personService.getPersonListByExpenses(tasksId);
        return personDTOMapper.personListToPersonDTOList(personList);


    }


    @GetMapping("/getPersonListByPersonId")
    public List<PersonDTO> getPersonListByPersonId(@RequestParam Long personId) {
        List<Person> personList = personService.getPersonListByPersonId(personId);
        return personDTOMapper.personListToPersonDTOList(personList);
    }
    //--- Other


}
