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

- [ ] nickName
- [ ] firstName
- [ ] middleName
- [ ] lastName
- [ ] fullName
- [ ] description
- [ ] emailList
- [ ] phoneNumberList
- [ ] anniversaryList
- [ ] relatedPersonList
- [ ] subject
- [ ] creator
- [ ] userList
- [ ] personTagList
- [ ] personReminderList
- [ ] personTopicList
- [ ] personTasksList
- [ ] personHistoryList
- [ ] documentList
- [ ] addressList

### Post

- [ ] postPerson

### Put

- [ ] putNickNameToPerson
- [ ] putFirstNameToPerson
- [ ] putMiddleNameToPerson
- [ ] putLastNameToPerson
- [ ] putDescriptionToPerson
- [ ] putEmailToPerson
- [ ] putPhoneNumberToPerson
- [ ] putAnniversaryToPerson
- [ ] putRelatedPersonToPerson
- [ ] putSubjectToPerson
- [ ] putUserToPerson
- [ ] putTagToPerson
- [ ] putReminderToPerson
- [ ] putTopicToPerson
- [ ] putTasksToPerson
- [ ] putDocumentToPerson
- [ ] putAddressToPerson


### Delete

- [ ] deleteDocumentFromPerson
- [ ] deleteEmailFromPerson
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
- [ ] getPersonBySubject
- [ ] getPersonListBySubjectContains
- [ ] getPersonListByCNP
- [ ] getPersonListByCNPContains
- [ ] getPersonListByFirstName
- [ ] getPersonListByFirstNameContains
- [ ] getPersonListByMiddleName
- [ ] getPersonListByMiddleNameContains
- [ ] getPersonListByLastName
- [ ] getPersonListByLastNameContains
- [ ] getPersonListByFullName
- [ ] getPersonListByFullNameContains
- [ ] getPersonListByEmail
- [ ] getPersonListByEmailContains
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