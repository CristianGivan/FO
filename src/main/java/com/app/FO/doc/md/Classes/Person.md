# Person

- tags colegue, busnisx
- reminder: call him in x
- if there are 2 persons with the same full name than the CNP can be added to make to distinguish (is not necessarily a
  real CNP)

# ToDo

## Entity

- [ ] Add creator (log in user)
- [1] Add in entity and constructor, getter, setter, toString:
   ```
      @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
      @JoinColumn(name = "user_id")
      @JsonIgnore
      private User creator;
  ```
- [2] Add in user and getter setter toString:
  ```
      @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
      private List<Entity> entityList;
  ```

### DTO

- [ ] Create DTO
- [ ] Create FDTO
- [ ] Create Mapper
    - Add in uses the mappers needed:
      ```
      uses = {UserDTOMapper.class}
      ```
    - Add @Autowired DTOMapper for the list is needed to be created
      ```
       @Autowired
       protected UserDTOMapper userDTOMapper;
      ```

### Entity

- [ ] Add to all OneToMany the orphanRemoval and cascade

```
, orphanRemoval = true,  cascade = {CascadeType.PERSIST, CascadeType.MERGE}
```

### Attributes

- [ ] CNP
- [ ] firstName
- [ ] middleName
- [ ] lastName
- [ ] fullName
- [ ] emailList
- [ ] phoneNumberList
- [ ] anniversaryList
- [ ] addressList
- [ ] relatedPersonList
- [ ] creator
- [ ] userList
- [ ] personTagList
- [ ] personReminderList
- [ ] personTopicList
- [ ] personTasksList
- [ ] personHistoryList

### Post

- [ ] postPerson

### Put

- [ ] putCNPToPerson
- [ ] putFirstNameToPerson
- [ ] putMiddleNameToPerson
- [ ] putLastNameToPerson
- [ ] putEmailListToPerson
- [ ] putPhoneNumberListToPerson
- [ ] putAnniversaryListToPerson
- [ ] putAddressListToPerson
- [ ] putRelatedPersonListToPerson
- [ ] putUserToPerson
- [ ] putTagToPerson
- [ ] putReminderToPerson
- [ ] putTopicToPerson
- [ ] putTasksToPerson

### Delete

- [ ] deleteFirstNameFromPerson
- [ ] deleteMiddleNameToPerson
- [ ] deleteLastNameToFromPerson
- [ ] deleteEmailListFromPerson
- [ ] deletePhoneNumberFromPerson
- [ ] deleteAnniversaryFromPerson
- [ ] deleteUserFromPerson
- [ ] deleteTagFromPerson
- [ ] deleteReminderFromPerson
- [ ] deleteTopicFromPerson
- [ ] deleteTasksFromPerson
- [ ] deletePerson

### Get

- [ ] getAllPerson
- [ ] getPersonById
- [ ] getTaskBySubject
- [ ] getTaskListBySubjectContains
- [ ] getPersonListByCNP
- [ ] getTaskListByCNPContains
- [ ] getPersonListByFirstName
- [ ] getTaskListByFirstNameContains
- [ ] getPersonListByMiddleName
- [ ] getTaskListByMiddleNameContains
- [ ] getPersonListByLastName
- [ ] getTaskListByLastNameContains
- [ ] getPersonListByFullName
- [ ] getTaskListByFullNameContains
- [ ] getPersonListByEmail
- [ ] getTaskListByEmailContains
- [ ] getPersonListByPhoneNumber
- [ ] getPersonListByAnniversary
- [ ] getPersonListByAddress
- [ ] getPersonListByRelatedPerson
- [ ] getPersonListByCreatedDate
- [ ] getLinkByCreatedDate
- [ ] getPersonListByUser
- [ ] getPersonListByTag
- [ ] getPersonListByReminder
- [ ] getPersonListByTopic
- [ ] getPersonListByTasks

## Other