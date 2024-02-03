# General

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

- [x] subject
- [x] createdDate
- [x] creator
- [x] eventUserList
- [x] eventTagList
- [x] eventReminderList
- [x] eventTopicList
- [x] eventTasksList
- [x] eventExpensesList
- [x] eventPersonList
- [x] eventHistoryList

### Post

- [x] postEvent

### Put

- [x] putSubjectToEvent
- [x] putUserToEvent
- [x] putTagToEvent
- [x] putReminderToEvent
- [x] putTopicToEvent
- [x] putTasksToEvent
- [x] putToExpensesEvent
- [x] putPersonToEvent

### Delete

- [ ] deleteUserFromEvent
- [ ] deleteTagFromEvent
- [ ] deleteReminderFromEvent
- [ ] deleteTopicFromEvent
- [ ] deleteTasksFromEvent
- [ ] deleteExpensesFromEvent
- [ ] deletePersonFromEvent
- [ ] deleteEvent

### Get

- [x] getAllEvent
- [x] getEventById
- [x] getEvenBySubject
- [x] getEvenListBySubjectContains
- [x] getEventByCreatedDate
- [x] getEventListByCreatedDateBetween
- [x] getEventListByUser
- [x] getEventListByTag
- [x] getEventListByReminder
- [x] getEventListByTopic
- [x] getEventListByTasks
- [x] getEventListByExpenses
- [x] getEventListByPerson

## Other
