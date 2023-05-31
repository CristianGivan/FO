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
- [ ] subject
- [ ] workingDate
- [ ] workingTime
- [ ] createdDate
- [ ] creator
- [ ] userList
- [ ] workTopicList
- [ ] workTaskList
- [ ] workTagList
- [ ] workReminderList
- [ ] workHistoryList

### Post
- [] postWork

### Put
- [] putSubjectToWork
- [] putUserToWork
- [] putTagToWork
- [] putReminderToWork
- [] putTopicToWork
- [] putTaskToWork
- [] putStartDateToWork
- [] putEndDateToWork
- [] putWorkStatusToWork

### Delete
- [] deleteUserFromWork
- [] deleteTagFromWork
- [] deleteReminderFromWork
- [] deleteTopicFromWork
- [] deleteTaskFromWork
- [] deleteWork

### Get
- [] getAllWork
- [] getWorkBySubject
- [] getWorkListBySubjectContains
- [] getWorkByWorkId
- [] getWorkByUserId
- [] getWorkListByTagId
- [] getWorkListByReminderId
- [] getWorkListByTopicId
- [] getWorkListByTaskId
- [] getWorkByStartDate
- [] getWorkByEndDate
- [] getWorkByWorkStatus
## Other
