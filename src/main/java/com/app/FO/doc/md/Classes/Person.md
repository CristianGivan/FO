# Person

- tags colegue, busnisx 
- reminder: call him in x
- 

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

- [ ] firstName
- [ ] middleName
- [ ] lastName
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

- [ ] deleteUserFromPerson
- [ ] deleteTagFromPerson
- [ ] deleteReminderFromPerson
- [ ] deleteTopicFromPerson
- [ ] deleteTasksFromPerson
- [ ] deletePerson

### Get

- [ ] getAllPerson
- [ ] getPersonById
- [ ] getPersonListByFirstName
- [ ] getPersonListByMiddleName
- [ ] getPersonListByLastName
- [ ] getPersonListByEmail
- [ ] getPersonListByPhoneNumber
- [ ] getPersonListByAnniversary
- [ ] getPersonListByAddress
- [ ] getPersonListByRelatedPerson
- [ ] getPersonListByUser
- [ ] getPersonListByTag
- [ ] getPersonListByReminder
- [ ] getPersonListByTopic
- [ ] getPersonListByTasks

## Other