package com.app.FO.service.person;

import com.app.FO.exceptions.*;
import com.app.FO.model.person.*;
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

    public Person postPerson(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Person person = personRepository.getPersonFromUserIdBySubject(logInUser.getId(), subject);
        if (person != null) {
            throw new PersonAlreadyExistException("Person with this subject already exist");
        }

        person = personRepository.save(new Person(subject, logInUser));

        PersonUser personUser = new PersonUser(person, logInUser);
        person.getPersonUserList().add(personUser);

        return personRepository.save(person);
    }

    //-- Put
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

    public Person getPersonByPersonId(Long personId) {
        User logInUser = serviceAll.getLogInUser();
        Person person = personRepository.getPersonFromUserIdByPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("No person found");
        }
        return person;
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

    //-- Other


}
