# Person

- tags colegue, busnisx
- description something that can distinguish by other person with the same name and also to have a better reference
  about that peron like is a mechanic has a business he presented x person is sister of
- subject had the name concatenated with description shall be done uniq by the short description

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

- [x] nickName
- [x] firstName
- [x] middleName
- [x] lastName
- [x] fullName
- [x] description
- [x] subject
- [x] createdDate
- [x] creator
- [x] userList
- [x] personTagList
- [x] personReminderList
- [x] personTopicList
- [x] personTasksList
- [x] personDocumentList
- [x] personAddressList
- [x] personEmailList
- [x] personPhoneNumberList
- [x] personDatesList
- [x] expensesPersonList
- [x] relatedPersonList
- [x] personHistoryList

### Post

- [ ] postPerson

### Put

- [ ] putNickNameToPerson
- [ ] putFirstNameToPerson
- [ ] putMiddleNameToPerson
- [ ] putLastNameToPerson
- [ ] putDescriptionToPerson
- [ ] putSubjectToPerson
- [ ] putUserToPerson
- [ ] putTagToPerson
- [ ] putReminderToPerson
- [ ] putTopicToPerson
- [ ] putTasksToPerson
- [ ] putDocumentToPerson
- [ ] putAddressToPerson
- [ ] putEmailToPerson
- [ ] putPhoneNumberToPerson
- [ ] putDatesToPerson
- [ ] putRelatedPersonToPerson

### Delete

- [ ] deleteEmailFromPerson
- [ ] deletePhoneNumberFromPerson
- [ ] deleteDatesFromPerson
- [ ] deleteUserFromPerson
- [ ] deleteTagFromPerson
- [ ] deleteReminderFromPerson
- [ ] deleteTopicFromPerson
- [ ] deleteTasksFromPerson
- [ ] deleteDocumentFromPerson
- [ ] deleteAddressFromPerson
- [ ] deleteEmailFromPerson
- [ ] deletePhoneNumberFromPerson
- [ ] deleteDatesFromPerson
- [ ] deleteRelatedPersonFromPerson
- [ ] deletePerson

### Get

- [ ] getAllPerson
- [ ] getPersonById
- [ ] getPersonListByNickName
- [ ] getPersonListByNickNameContains
- [ ] getPersonListByFirstName
- [ ] getPersonListByFirstNameContains
- [ ] getPersonListByMiddleName
- [ ] getPersonListByMiddleNameContains
- [ ] getPersonListByLastName
- [ ] getPersonListByLastNameContains
- [ ] getPersonListByFullName
- [ ] getPersonListByFullNameContains
- [ ] getPersonListByDescription
- [ ] getPersonListByDescriptionContains
- [ ] getPersonListByEmail
- [ ] getPersonListByEmailContains
- [ ] getPersonListByPhoneNumber
- [ ] getPersonBySubject
- [ ] getPersonListBySubjectContains
- [ ] getPersonByCreatedDate
- [ ] getPersonListByCreatedDateBetween
- [ ] getPersonListByRelatedPerson
- [ ] getPersonListByUser
- [ ] getPersonListByTag
- [ ] getPersonListByReminder
- [ ] getPersonListByTopic
- [ ] getPersonListByTasks
- [ ] getPersonListByDocument
- [ ] getPersonListByAddress
- [ ] getPersonListByEmail
- [ ] getPersonListByPhoneNumber
- [ ] getPersonListByDates
- [ ] getPersonListByDatesBetween
- [ ] getPersonListByExpenses
- [ ] getPersonListByRelatedPerson

## Other