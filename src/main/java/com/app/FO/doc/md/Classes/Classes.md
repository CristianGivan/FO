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

### Service

- [ ] post
    - [ ] getLogInUser (userService.getLogInUser())
    - [ ] Check if record with the param1 already exist
    - [ ] Create an entity adding creator
    - [ ] Create an entityUser
    - [ ] Save record

- [ ] putStringToId
    - [1] getLogInUser (userService.getLogInUser())
    - [2] Check if parameter1 (by id) exists (from log in user)
    - [3] Check if record with the parameter1 already exist
    - [4] Add parameter2 in parameter1
    - [5] Save record (entityRepository.save(entity))

- [ ] putIdToId
    - [1] getLogInUser (userService.getLogInUser())
    - [2] Check if parameter1 (by id) exists (from log in user)
    - [3] Check if parameter2 (by id) exists (from log in user)
    - [4] Check if parameter1 has parameter2 (serviceAll.getParameter1Parameter2)
    - [5] Create a parameter1Parameter2 record in linking table
    - [6] Add parameter2 in parameter1 list (.getParameter1Parameter2List.set)
    - [7] Save record (entityRepository.save(entity))

- [ ] deleteIdFromId
    - [1] getLogInUser (userService.getLogInUser())
    - [2] Check if parameter1 (by id) exists (from log in user)
    - [3] Check if parameter2 (by id) exists (from log in user)
    - [4] Check if parameter1 has parameter2 (serviceAll.getParameter1Parameter2)
    - [5] Create a parameter1Parameter2 record in linking table
    - [6] Delete parameter2 in parameter1 list (.getParameter1Parameter2List.set)
    - [7] Save record (entityRepository.save(entity))

### Attributes

- [ ] subject
- [ ] workingDate
- [ ] workingTime
- [ ] createdDate
- [ ] creator
- [ ] userList
- [ ] workTagList
- [ ] workReminderList
- [ ] workTopicList
- [ ] workTaskList
- [ ] workHistoryList

### Post

- [ ] postWork

### Put

- [ ] putSubjectToWork
- [ ] putWorkingDateToWork
- [ ] putWorkingTimeToWork
- [ ] putUserToWork
- [ ] putTagToWork
- [ ] putReminderToWork
- [ ] putTopicToWork
- [ ] putTaskToWork

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
- [ ] getWorkByWorkingDate
- [ ] getWorkByWorkingTime
- [ ] getWorkByUser
- [ ] getWorkListByTag
- [ ] getWorkListByReminder
- [ ] getWorkListByTopic
- [ ] getWorkListByTask

## Other
