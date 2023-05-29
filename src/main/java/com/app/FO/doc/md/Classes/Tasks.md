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
- subject
- creator
- createdDate
- startDate
- endDate
- taskStatus
- taskTopicList
- tasksTaskList
- userList
- taskTagList
- taskReminderList
- tasksTaskList
- taskHistoryList

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

### Post
- [x] postTasks
  - [x] getLogInUser (userService.getLogInUser())
  - [x] Check if record with the param1 already exist
  - [x] Create an entity adding creator
  - [x] Create an entityUser
  - [x] Save record

### Put
- [x] putSubjectToTasks
- [x] putUserToTasks
- [x] putTagToTasks
- [x] putReminderToTasks
- [x] putTopicToTasks
- [x] putTaskToTasks
- [x] putStartDateToTasks
- [x] putEndDateToTasks
- [x] putTasksStatusToTasks

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
- [ ] getTasksByUserId
- [x] getTasksListByTagId
- [x] getTasksListByReminderId
- [x] getTasksListByTopicId
- [x] getTasksListByTaskId
- [x] getTasksByStartDate
- [x] getTasksByEndDate
- [x] getTasksByTasksStatus
## Other
