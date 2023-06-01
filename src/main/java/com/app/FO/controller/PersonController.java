package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.person.PersonDTO;
import com.app.FO.mapper.mappers.PersonDTOMapper;
import com.app.FO.model.person.Person;
import com.app.FO.service.person.PersonService;
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
    public PersonDTO postNewPerson(@RequestBody TextDTO noteText) {
        Person person = personService.postPerson(noteText.getText());
        return personDTOMapper.personToPersonDTO(person);
    }


    //-- PutMapping
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

    @GetMapping("/getPersonById")
    public PersonDTO getPersonById(@RequestParam Long personId) {
        Person person = personService.getPersonByPersonId(personId);
        return personDTOMapper.personToPersonDTO(person);
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


    //--- Other


}
