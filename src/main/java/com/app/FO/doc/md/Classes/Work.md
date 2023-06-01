# General
Only topic has a link

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

- [ ] subject
- [ ] workingDateTime
- [ ] workingEfort
- [ ] createdDate
- [ ] creator
- [ ] workUserList
- [ ] workTagList
- [ ] workReminderList
- [ ] workTopicList
- [ ] workTaskList
- [ ] workHistoryList

### Post

- [ ] postWork

### Put

- [ ] putSubjectToWork
- [ ] putUserToWork
- [ ] putTagToWork
- [ ] putReminderToWork
- [ ] putTopicToWork
- [ ] putTaskToWork
- [ ] putWorkingDateTimeToWork
- [ ] putWorkingEfortToWork

### Delete

- [ ] deleteUserFromWork
- [ ] deleteTagFromWork
- [ ] deleteReminderFromWork
- [ ] deleteTopicFromWork
- [ ] deleteTaskFromWork
- [ ] deleteWork

### Get

- [ ] getAllWork
- [ ] getWorkBySubject
- [ ] getWorkListBySubjectContains
- [ ] getWorkById
- [ ] getWorkListByUser
- [ ] getWorkListByTag
- [ ] getWorkListByReminder
- [ ] getWorkListByTopic
- [ ] getWorkListByTask
- [ ] getWorkByWorkingDateTime
- [ ] getWorkByWorkingEfort
- 
## Other
