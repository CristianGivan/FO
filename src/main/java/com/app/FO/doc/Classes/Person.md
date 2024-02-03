# Person

- tags colegue, busnisx
- description something that can distinguish by other person with the same name and also to have a better reference
  about that peron like is a mechanic has a business he presented x person is sister of
- subject had the name concatenated with description shall be done uniq by the short description
- getPersonListByRelatedPerson tbd

# ToDo

- [ ] deletePerson shall be update so that the entry where is linked other person
- [ ] getPersonListByRelatedPerson is not done properly

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

- [x] postPerson

### Put

- [x]  putNickNameToPerson
- [x]  putFirstNameToPerson
- [x]  putMiddleNameToPerson
- [x]  putLastNameToPerson
- [x]  putDescriptionToPerson
- [x]  putSubjectToPerson
- [x]  putUserToPerson
- [x]  putTagToPerson
- [x]  putReminderToPerson
- [x]  putTopicToPerson
- [x]  putTasksToPerson
- [x]  putDocumentToPerson
- [x]  putAddressToPerson
- [x]  putEmailToPerson
- [x]  putPhoneNumberToPerson
- [x]  putDatesToPerson
- [x]  putRelatedPersonToPerson

### Delete

- [x] deleteUserFromPerson
- [x] deleteTagFromPerson
- [x] deleteReminderFromPerson
- [x] deleteTopicFromPerson
- [x] deleteTasksFromPerson
- [x] deleteDocumentFromPerson
- [x] deleteAddressFromPerson
- [x] deleteEmailFromPerson
- [x] deletePhoneNumberFromPerson
- [x] deleteDatesFromPerson
- [x] deleteRelatedPersonFromPerson
- [ ] deletePerson

### Get

- [x] getAllPerson
- [x] getPersonById
- [x] getPersonListByNickName
- [x] getPersonListByNickNameContains
- [x] getPersonListByFirstName
- [x] getPersonListByFirstNameContains
- [x] getPersonListByMiddleName
- [x] getPersonListByMiddleNameContains
- [x] getPersonListByLastName
- [x] getPersonListByLastNameContains
- [x] getPersonListByFullName
- [x] getPersonListByFullNameContains
- [x] getPersonListByDescription
- [x] getPersonListByDescriptionContains
- [x] getPersonBySubject
- [x] getPersonListBySubjectContains
- [x] getPersonByCreatedDate
- [x] getPersonListByCreatedDateBetween
- [x] getPersonListByRelatedPerson
- [x] getPersonListByUser
- [x] getPersonListByTag
- [x] getPersonListByReminder
- [x] getPersonListByTopic
- [x] getPersonListByTasks
- [x] getPersonListByDocument
- [x] getPersonListByAddress
- [x] getPersonListByEmail
- [x] getPersonListByPhoneNumber
- [x] getPersonListByDates
- [x] getPersonListByExpenses
- [ ] getPersonListByRelatedPerson

## Other