# General

- Tasks have a subject where is a short description of the task
- Tasks have a topic where more details about it are present
- When a task is created also the topic is crated
- Work should be the work you apply to task
    - Work has topic where specified the work done
- estimatedTime is the time estimated to work on this task
- workingTime is the time worked at the task is sum of all work done
- workingProgress is the work done to complete the task
- [ ] putEstimatedTimeToTask is done at putWork
- [ ] putWorkingTimeTimeToTask is done at putWork
- [x] startDate when is estimated to start the task
- [x] endDate when is estimated to finish the task.
- [x] taskStatus The date hen is finish is set to Completed

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

### Entity

- [ ] Add to all OneToMany the orphanRemoval and cascade

```
, orphanRemoval = true,  cascade = {CascadeType.PERSIST, CascadeType.MERGE}
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

### Attributes

- [x] subject
- [x] createdDate
- [x] startDate
- [x] endDate
- [x] workingTime
- [x] estimatedTime
- [x] estimatedLeftTime
- [x] workingProgress
- [x] taskStatus
- [x] creator
- [x] taskUserList
- [x] taskTagList
- [x] taskReminderList
- [x] taskTopicList
- [x] taskWorkList
- [x] tasksTaskList
- [x] taskHistoryList

### Post

- [x] postTask

### Put

- [x] putSubjectToTask
- [x] putStartDateToTask
- [x] putEndDateToTask
- [x] putUserToTask
- [x] putTagToTask
- [x] putReminderToTask
- [x] putTopicToTask
- [                ] putWorkToTask
- [x] putTaskStatusToTask

### Delete

- [x] deleteUserFromTask
- [x] deleteTagFromTask
- [x] deleteReminderFromTask
- [x] deleteTopicFromTask
- [x] deleteWorkFromTask
- [x] deleteTask

### Get

- [x] getAllTask
- [x] getTaskBySubject
- [x] getTaskListBySubjectContains
- [x] getTaskByCreatedDate
- [x] getTaskListByCreatedDateBetween
- [x] getTaskListByStartDate
- [x] getTaskListByStartDateBetween
- [x] getTaskListByEndDate
- [x] getTaskListByEndDateBetween
- [x] getTaskListByWorkingTime
- [x] getTaskListByWorkingTimeBetween
- [x] getTaskListByEstimatedTime
- [x] getTaskListByEstimatedTimeBetween
- [x] getTaskListByEstimatedLeftTime
- [x] getTaskListByEstimatedLeftTimeBetween
- [x] getTaskListByWorkingProgress
- [ ] getTaskListByTaskStatus
- [x] getTaskByTaskId
- [x] getTasksListByUserId
- [x] getTaskListByTagId
- [x] getTaskListByReminderId
- [x] getTaskListByTopicId
- [x] getTaskListByWorkId
- [x] getTaskByStartDate
- [x] getTaskByEndDate
- [x] getTaskByTaskStatus

## Other
