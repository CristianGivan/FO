# General

- Tasks have a subject where is a short description of the task
- Tasks have a topic where more details about it are present
- When a task is created also the topic is crated
- Work should be the work you apply to task
  - Work has topic where specified the work done
- estimatedTime is the time estimated to work on this task
- workingTime is the time worked at the task is sum of all work done
- workingProgress is the work done to complete the task

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
- subject
- startDate
- endDate
- taskStatus
- estimatedTime
- workingTime
- workingProgress
- createdDate
- creator
- userList
- taskWorkList
- taskTagList
- taskReminderList
- taskTopicList
- tasksTaskList
- taskHistoryList

### Post
- [x] postTask

### Put
- [x] putSubjectToTask
- [x] putUserToTask
- [x] putTagToTask
- [x] putReminderToTask
- [x] putTopicToTask
- [x] putWorkToTask
- [x] putStartDateToTask
- [x] putEndDateToTask
- [x] putTaskStatusToTask
- [ ] putEstimatedTimeToTask
- [ ] putWorkingTimeTimeToTask
- [ ] putWorkingProgressToTask

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
- [x] getTaskByTaskId
- [x] getTasksByUserId
- [x] getTaskListByTagId
- [x] getTaskListByReminderId
- [x] getTaskListByTopicId
- [x] getTaskListByWorkId
- [x] getTaskByStartDate
- [x] getTaskByEndDate
- [x] getTaskByTaskStatus

## Other
