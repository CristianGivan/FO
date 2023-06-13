package com.app.FO.model.person;

import com.app.FO.model.expenses.ExpensesPerson;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name = "person_seq",
            sequenceName = "person_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "nickName")
    private String nickName;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "middleName")
    private String middleName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "description")
    private String description;

    @Column(name = "subject")
    private String subject;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonUser> personUserList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonTag> personTagList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonReminder> personReminderList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonTopic> personTopicList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonTasks> personTasksList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonDocument> personDocumentList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonAddress> personAddressList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonEmail> personEmailList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonPhoneNumber> personPhoneNumberList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonTheDay> personTheDayList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesPerson> expensesPayerList;

    @OneToMany
    @JoinColumn(name = "related_person")
    private List<Person> relatedPersonList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonHistory> personHistoryList;


    public Person() {
    }

    public Person(String nickName, String description, User creator) {
        this.nickName = nickName;
        this.description = description;
        this.subject = nickName + " " + description;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", personUserList=" + personUserList +
                ", personTopicList=" + personTopicList +
                ", personTasksList=" + personTasksList +
                ", personUserList=" + personUserList +
                ", personTagList=" + personTagList +
                ", personReminderList=" + personReminderList +
                ", personDocumentList=" + personDocumentList +
                ", personAddressList=" + personAddressList +
                ", personEmailList=" + personEmailList +
                ", personPhoneNumberList=" + personPhoneNumberList +
                ", personTheDayList=" + personTheDayList +
                ", expensesPayerList=" + expensesPayerList +
                ", relatedPersonList=" + relatedPersonList +
                ", personHistoryList=" + personHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        if (nickName == null) {
            nickName = "";
        }
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFirstName() {
        if (firstName == null) {
            firstName = "";
        }
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        if (middleName == null) {
            middleName = "";
        }
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        if (lastName == null) {
            lastName = "";
        }
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        if (fullName == null) {
            fullName = "";
        }
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        if (description == null) {
            description = "";
        }
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubject() {
        if (subject == null) {
            subject = "";
        }
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<PersonUser> getPersonUserList() {
        if (personUserList == null) {
            personUserList = new ArrayList<>();
        }
        return personUserList;
    }

    public void setPersonUserList(List<PersonUser> personUserList) {
        this.personUserList = personUserList;
    }

    public List<PersonTag> getPersonTagList() {
        return personTagList;
    }

    public void setPersonTagList(List<PersonTag> personTagList) {
        this.personTagList = personTagList;
    }

    public List<PersonReminder> getPersonReminderList() {
        return personReminderList;
    }

    public void setPersonReminderList(List<PersonReminder> personReminderList) {
        this.personReminderList = personReminderList;
    }

    public List<PersonHistory> getPersonHistoryList() {
        return personHistoryList;
    }

    public void setPersonHistoryList(List<PersonHistory> personHistoryList) {
        this.personHistoryList = personHistoryList;
    }

    public List<PersonTopic> getPersonTopicList() {
        return personTopicList;
    }

    public void setPersonTopicList(List<PersonTopic> personTopicList) {
        this.personTopicList = personTopicList;
    }

    public List<PersonTasks> getPersonTasksList() {
        return personTasksList;
    }

    public void setPersonTasksList(List<PersonTasks> personTasksList) {
        this.personTasksList = personTasksList;
    }

    public List<PersonDocument> getPersonDocumentList() {
        return personDocumentList;
    }

    public void setPersonDocumentList(List<PersonDocument> personDocumentList) {
        this.personDocumentList = personDocumentList;
    }

    public List<PersonAddress> getPersonAddressList() {
        return personAddressList;
    }

    public void setPersonAddressList(List<PersonAddress> personAddressList) {
        this.personAddressList = personAddressList;
    }

    public List<PersonEmail> getPersonEmailList() {
        return personEmailList;
    }

    public void setPersonEmailList(List<PersonEmail> personEmailList) {
        this.personEmailList = personEmailList;
    }

    public List<PersonPhoneNumber> getPersonPhoneNumberList() {
        return personPhoneNumberList;
    }

    public void setPersonPhoneNumberList(List<PersonPhoneNumber> personPhoneNumberList) {
        this.personPhoneNumberList = personPhoneNumberList;
    }

    public List<PersonTheDay> getPersonTheDayList() {
        return personTheDayList;
    }

    public void setPersonTheDayList(List<PersonTheDay> personTheDayList) {
        this.personTheDayList = personTheDayList;
    }

    public List<ExpensesPerson> getExpensesPayerList() {
        return expensesPayerList;
    }

    public void setExpensesPayerList(List<ExpensesPerson> expensesPayerList) {
        this.expensesPayerList = expensesPayerList;
    }

    public List<Person> getRelatedPersonList() {
        return relatedPersonList;
    }

    public void setRelatedPersonList(List<Person> relatedPersonList) {
        this.relatedPersonList = relatedPersonList;
    }
}
