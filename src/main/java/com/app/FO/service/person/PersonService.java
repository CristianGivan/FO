package com.app.FO.service.person;

import com.app.FO.exceptions.*;
import com.app.FO.model.address.Address;
import com.app.FO.model.dates.Dates;
import com.app.FO.model.document.Document;
import com.app.FO.model.email.Email;
import com.app.FO.model.person.*;
import com.app.FO.model.phoneNumber.PhoneNumber;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.person.PersonRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    private ServiceAll serviceAll;

    @Autowired
    public PersonService(PersonRepository personRepository, ServiceAll serviceAll) {
        this.personRepository = personRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Person postPerson(String nickName, String description) {
        User logInUser = serviceAll.getLogInUser();

        String subject = nickName + " " + description;

        Person person = personRepository.getPersonFromUserIdBySubject(logInUser.getId(), subject);
        if (person != null) {
            throw new PersonAlreadyExistException("Person with this subject already exist");
        }

        person = personRepository.save(new Person(nickName, description, logInUser));

        PersonUser personUser = new PersonUser(person, logInUser);
        person.getPersonUserList().add(personUser);

        return personRepository.save(person);
    }

    //-- Put
    public Person putNickNameToPerson(Long personId, String nickName) {
        User logInUser = serviceAll.getLogInUser();
        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        if (person.getNickName().equals(nickName)) {
            throw new PersonAlreadyExistException("Person has already the same nickName");
        }

        person.setNickName(nickName);
        person.setSubject(nickName + " " + person.getDescription());
        return personRepository.save(person);
    }

    public Person putFirstNameToPerson(Long personId, String firstName) {
        User logInUser = serviceAll.getLogInUser();
        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        if (person.getFirstName().equals(firstName)) {
            throw new PersonAlreadyExistException("Person has already the same firstName");
        }

        person.setFirstName(firstName);
        person.setFullName(person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName());

        return personRepository.save(person);
    }

    public Person putMiddleNameToPerson(Long personId, String middleName) {
        User logInUser = serviceAll.getLogInUser();
        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        if (person.getMiddleName().equals(middleName)) {
            throw new PersonAlreadyExistException("Person has already the same middleName");
        }

        person.setMiddleName(middleName);
        person.setFullName(person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName());

        return personRepository.save(person);
    }

    public Person putLastNameToPerson(Long personId, String lastName) {
        User logInUser = serviceAll.getLogInUser();
        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        if (person.getLastName().equals(lastName)) {
            throw new PersonAlreadyExistException("Person has already the same lastName");
        }

        person.setLastName(lastName);
        person.setFullName(person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName());

        return personRepository.save(person);
    }

    public Person putDescriptionToPerson(Long personId, String description) {
        User logInUser = serviceAll.getLogInUser();
        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        if (person.getDescription().equals(description)) {
            throw new PersonAlreadyExistException("Person has already the same description");
        }

        person.setDescription(description);
        person.setSubject(person.getNickName() + " " + description);
        return personRepository.save(person);
    }

    public Person putSubjectToPerson(Long personId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        if (person.getSubject().equals(subject)) {
            throw new PersonAlreadyExistException("Person has already the same subject");
        }

        person.setSubject(subject);

        return personRepository.save(person);
    }

    public Person putUserToPerson(Long personId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        PersonUser personUser = serviceAll.getPersonUser(personId, userId);
        if (personUser != null) {
            throw new PersonUserAlreadyExistException("The person already has the user");
        }

        personUser = new PersonUser(person, user);
        person.getPersonUserList().add(personUser);

        return personRepository.save(person);
    }

    public Person putTagToPerson(Long personId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        PersonTag personTag = serviceAll.getPersonTag(personId, tagId);
        if (personTag != null) {
            throw new PersonTagAlreadyExistException("The person already has the tag");
        }

        personTag = new PersonTag(person, tag);
        person.getPersonTagList().add(personTag);

        return personRepository.save(person);
    }


    public Person putReminderToPerson(Long personId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        PersonReminder personReminder = serviceAll.getPersonReminder(personId, reminderId);
        if (personReminder != null) {
            throw new PersonReminderAlreadyExistException("The person already has the reminder");
        }

        personReminder = new PersonReminder(person, reminder);
        person.getPersonReminderList().add(personReminder);

        return personRepository.save(person);
    }

    public Person putTopicToPerson(Long personId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        PersonTopic personTopic = serviceAll.getPersonTopic(personId, topicId);
        if (personTopic != null) {
            throw new PersonTopicAlreadyExistException("The person already has the topic");
        }

        personTopic = new PersonTopic(person, topic);
        person.getPersonTopicList().add(personTopic);
        return personRepository.save(person);
    }

    public Person putTasksToPerson(Long personId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        PersonTasks personTasks = serviceAll.getPersonTasks(personId, tasksId);
        if (personTasks != null) {
            throw new PersonTasksAlreadyExistException("The person already has the tasks");
        }

        personTasks = new PersonTasks(person, tasks);
        person.getPersonTasksList().add(personTasks);
        return personRepository.save(person);
    }


    public Person putDocumentToPerson(Long personId, Long documentId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Document document = serviceAll.getDocumentFromUserIdAndDocumentId(logInUser.getId(), documentId);
        if (document == null) {
            throw new DocumentNotFoundException("Document not found");
        }

        PersonDocument personDocument = serviceAll.getPersonDocument(personId, documentId);
        if (personDocument != null) {
            throw new PersonDocumentAlreadyExistException("The person already has the document");
        }

        personDocument = new PersonDocument(person, document);
        person.getPersonDocumentList().add(personDocument);
        return personRepository.save(person);
    }


    public Person putAddressToPerson(Long personId, Long addressId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Address address = serviceAll.getAddressFromUserIdAndAddressId(logInUser.getId(), addressId);
        if (address == null) {
            throw new AddressNotFoundException("Address not found");
        }

        PersonAddress personAddress = serviceAll.getPersonAddress(personId, addressId);
        if (personAddress != null) {
            throw new PersonAddressAlreadyExistException("The person already has the address");
        }

        personAddress = new PersonAddress(person, address);
        person.getPersonAddressList().add(personAddress);
        return personRepository.save(person);
    }

    public Person putEmailToPerson(Long personId, Long emailId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Email email = serviceAll.getEmailFromUserIdAndEmailId(logInUser.getId(), emailId);
        if (email == null) {
            throw new EmailNotFoundException("Email not found");
        }

        PersonEmail personEmail = serviceAll.getPersonEmail(personId, emailId);
        if (personEmail != null) {
            throw new PersonEmailAlreadyExistException("The person already has the email");
        }

        personEmail = new PersonEmail(person, email);
        person.getPersonEmailList().add(personEmail);
        return personRepository.save(person);
    }

    public Person putPhoneNumberToPerson(Long personId, Long phoneNumberId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        PhoneNumber phoneNumber = serviceAll.getPhoneNumberFromUserIdAndPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (phoneNumber == null) {
            throw new PhoneNumberNotFoundException("PhoneNumber not found");
        }

        PersonPhoneNumber personPhoneNumber = serviceAll.getPersonPhoneNumber(personId, phoneNumberId);
        if (personPhoneNumber != null) {
            throw new PersonPhoneNumberAlreadyExistException("The person already has the phoneNumber");
        }

        personPhoneNumber = new PersonPhoneNumber(person, phoneNumber);
        person.getPersonPhoneNumberList().add(personPhoneNumber);
        return personRepository.save(person);
    }

    public Person putDatesToPerson(Long personId, Long datesId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Dates dates = serviceAll.getDatesFromUserIdAndDatesId(logInUser.getId(), datesId);
        if (dates == null) {
            throw new DatesNotFoundException("Dates not found");
        }

        PersonDates personDates = serviceAll.getPersonDates(personId, datesId);
        if (personDates != null) {
            throw new PersonDatesAlreadyExistException("The person already has the dates");
        }

        personDates = new PersonDates(person, dates);
        person.getPersonDatesList().add(personDates);
        return personRepository.save(person);
    }

    public Person putPersonToPerson(Long personId, Long reletedPersonId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Person reletedPerson = serviceAll.getPersonFromUserIdAndPersonId(logInUser.getId(), reletedPersonId);
        if (reletedPerson == null) {
            throw new PersonNotFoundException("Person not found");
        }

        PersonPerson personPerson = serviceAll.getPersonPerson(personId, reletedPersonId);
        if (personPerson != null) {
            throw new PersonPersonAlreadyExistException("The person already has the reletedPerson");
        }

        personPerson = new PersonPerson(person, reletedPerson);
        person.getPersonPersonList().add(personPerson);
        return personRepository.save(person);
    }

    //--Delete


    public Person deleteUserFromPerson(Long personId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        PersonUser personUser = serviceAll.getPersonUser(personId, userId);
        if (personUser == null) {
            throw new PersonUserNotFoundException("The person don't has the user");
        }
        person.getPersonUserList().remove(personUser);

        return personRepository.save(person);
    }

    public Person deleteTagFromPerson(Long personId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        PersonTag personTag = serviceAll.getPersonTag(personId, tagId);
        if (personTag == null) {
            throw new PersonTagNotFoundException("The person don't has the tag");
        }

        person.getPersonTagList().remove(personTag);

        return personRepository.save(person);
    }

    public Person deleteReminderFromPerson(Long personId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        PersonReminder personReminder = serviceAll.getPersonReminder(personId, reminderId);
        if (personReminder == null) {
            throw new PersonReminderNotFoundException("The person don't has the reminder");
        }

        person.getPersonReminderList().remove(personReminder);

        return personRepository.save(person);
    }

    public Person deleteTopicFromPerson(Long personId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        PersonTopic personTopic = serviceAll.getPersonTopic(personId, topicId);
        if (personTopic == null) {
            throw new PersonTasksNotFoundException("The person don't has the topic");
        }

        person.getPersonTopicList().remove(personTopic);

        return personRepository.save(person);
    }

    public Person deleteTasksFromPerson(Long personId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        PersonTasks personTasks = serviceAll.getPersonTasks(personId, tasksId);
        if (personTasks == null) {
            throw new PersonTasksNotFoundException("The person don't has the tasks");
        }

        person.getPersonTasksList().remove(personTasks);

        return personRepository.save(person);
    }

    public List<Person> deletePerson(Long personId) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found in your list");
        }
        personRepository.delete(person);
        return getAllPerson();
    }
    //-- GET


    public List<Person> getAllPerson() {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserId(logInUser.getId());
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }


    public Person getPersonByPersonId(Long personId) {
        User logInUser = serviceAll.getLogInUser();
        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("No person found");
        }
        return person;
    }

    public List<Person> getPersonListByNickName(String nickName) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonFromUserIdByNickName(logInUser.getId(), nickName);
        ;
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByNickNameContains(String nickNameContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListByNickNameContains(logInUser.getId(), nickNameContains);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByFirstName(String firstName) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonFromUserIdByFirstName(logInUser.getId(), firstName);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByFirstNameContains(String firstNameContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListByFirstNameContains(logInUser.getId(), firstNameContains);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByMiddleName(String middleName) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonFromUserIdByMiddleName(logInUser.getId(), middleName);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByMiddleNameContains(String middleNameContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListByMiddleNameContains(logInUser.getId(), middleNameContains);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByLastName(String lastName) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonFromUserIdByLastName(logInUser.getId(), lastName);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByLastNameContains(String lastNameContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListByLastNameContains(logInUser.getId(), lastNameContains);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByFullName(String fullName) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonFromUserIdByFullName(logInUser.getId(), fullName);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByFullNameContains(String fullNameContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListByFullNameContains(logInUser.getId(), fullNameContains);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByDescription(String description) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonFromUserIdByDescription(logInUser.getId(), description);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByDescriptionContains(String descriptionContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListByDescriptionContains(logInUser.getId(), descriptionContains);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public Person getPersonBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Person person = personRepository.getPersonFromUserIdBySubject(logInUser.getId(), subject);
        if (person == null) {
            throw new PersonNotFoundException("No person found");
        }
        return person;
    }

    public List<Person> getPersonListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListBySubjectContains(logInUser.getId(), subjectContains);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByUserId(logInUser.getId(), userId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByTagId(logInUser.getId(), tagId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByDocument(Long documentId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByDocumentId(logInUser.getId(), documentId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByAddress(Long addressId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByAddressId(logInUser.getId(), addressId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByEmail(Long emailId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByEmailId(logInUser.getId(), emailId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByPhoneNumberId(Long phoneNumberId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByPhoneNumberId(logInUser.getId(), phoneNumberId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByDatesId(Long datesId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByDatesId(logInUser.getId(), datesId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    public List<Person> getPersonListByExpenses(Long expensesId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }


    public List<Person> getPersonListByPersonId(Long personId) {
        User logInUser = serviceAll.getLogInUser();
        List<Person> personList = personRepository.getPersonListFromUserIdByPersonId(logInUser.getId(), personId);
        if (personList.isEmpty()) {
            throw new PersonNotFoundException("No person found");
        }
        return personList;
    }

    //-- Other


}
