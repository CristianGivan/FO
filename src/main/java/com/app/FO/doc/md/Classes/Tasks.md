# General

- Tasks have a subject where is a short description of the task
- Tasks have a topic where more details about it are present
- When a task is created also the topic is crated


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
- [x] startDate
- [x] endDate
- [x] taskStatus
- [x] createdDate
- [x] creator
- [x] tasksUserList
- [x] tasksTagList
- [x] tasksReminderList
- [x] tasksTopicList
- [x] tasksTaskList
- [x] taskHistoryList
- [ ] estimatedTime
- [ ] workingTime
- [ ] tasksProgress

### Post

- [x] postTasks

### Put

- [x] putSubjectToTasks
- [x] putUserToTasks
- [x] putTagToTasks
- [x] putReminderToTasks
- [x] putTopicToTasks
- [x] putTaskToTasks
- [x] putStartDateToTasks
- [x] putEndDateToTasks
- [x] putTaskStatusToTasks
- [ ] putEstimatedTimeToTask
- [ ] putWorkingTimeTimeToTask
- [ ] putWorkingProgressToTask

### Delete

- [x] deleteUserFromTasks
- [x] deleteTagFromTasks
- [x] deleteReminderFromTasks
- [x] deleteTopicFromTasks
- [x] deleteTaskFromTasks
- [x] deleteTasks

### Get

- [x] getAllTasks
- [x] getTasksBySubject
- [x] getTasksListBySubjectContains
- [x] getTasksByTasksId
- [x] getTasksListByUserId
- [x] getTasksListByTagId
- [x] getTasksListByReminderId
- [x] getTasksListByTopicId
- [x] getTasksListByTaskId
- [x] getTasksByStartDate
- [x] getTasksByEndDate
- [x] getTasksByTaskStatus
## Other
