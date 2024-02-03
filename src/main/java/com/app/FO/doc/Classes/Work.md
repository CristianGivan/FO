# General

Only topic has a link

- while working the estimation can be changed based on what came up but this had to be documented
    - 5 h plus because x work is harder that expected
    - 5 h minus because not needed to do work x
    - in subject can be mentioned estimation
- [ ] taskStatus tha status that will be transfer to Task as actual status
- [ ] workingProgress the progress that will be transfer to Task to be added to overview

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
- [x] workingDateTime
- [x] workingTime
- [x] estimatedTime
- [x] workingProgress
- [x] taskStatus
- [x] createdDate
- [x] creator
- [x] workUserList
- [x] workTagList
- [x] workReminderList
- [x] workTopicList
- [x] taskWorkList
- [x] workHistoryList

### Post

- [ ] postWork

### Put

- [x] putSubjectToWork
- [x] putWorkingDateTimeToWork
- [x] putWorkingTimeToWork
- [x] putEstimatedTimeToWork
- [x] putWorkingProgressToWork
- [x] putTaskStatusToWork
- [x] putUserToWork
- [x] putTagToWork
- [x] putReminderToWork
- [x] putTopicToWork

### Delete

- [x]  deleteUserFromWork
- [x]  deleteTagFromWork
- [x]  deleteReminderFromWork
- [x]  deleteTopicFromWork
- [x]  deleteTaskFromWork
- [x]  deleteWork

### Get

- [x]  getAllWork
- [x]  getWorkById
- [x]  getWorkBySubject
- [x]  getWorkListBySubjectContains
- [x]  getWorkByCreatedDate
- [x]  getWorkListByCreatedDateBetween
- [x]  getWorkListByWorkingDateTime
- [x]  getWorkListByWorkingDateTimeBetween
- [x]  getWorkListByWorkingTime
- [x]  getWorkListByWorkingTimeBetween
- [x]  getWorkListByEstimatedTime
- [x]  getWorkListByEstimatedTimeBetween
- [x]  getWorkListByWorkingProgress
- [x]  getTaskListByTaskStatus
- [x]  getWorkListByUser
- [x]  getWorkListByTag
- [x]  getWorkListByReminder
- [x]  getWorkListByTopic

## Other
