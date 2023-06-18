# General

- linkTopic I add topics that are important to that link ideas to don't remember
- topicLink I include the link as reference

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
- [x] reference
- [x] createdDate
- [x] creator
- [x] linkUserList
- [x] linkTagList
- [x] linkReminderList
- [x] linkTasksList
- [x] linkHistoryList

### Post

- [ ] postLink

### Put

- [x] putSubjectToLink
- [x] putReferenceToLink
- [x] putUserToLink
- [x] putTagToLink
- [x] putReminderToLink
- [x] putTopicToLink
- [x] putTasksToLink

### Delete

- [x] deleteUserFromLink
- [x] deleteTagFromLink
- [x] deleteReminderFromLink
- [x] deleteTopicFromLink
- [x] deleteTasksFromLink
- [x] deleteLink

### Get

- [x] getAllLink
- [x] getLinkById
- [x] getLinkBySubject
- [x] getLinkListBySubjectContains
- [x] getLinkByReference
- [x] getLinkListByReferenceContains
- [x] getLinkByCreatedDate
- [x] getLinkListByCreatedDateBetween
- [x] getLinkListByUser
- [x] getLinkListByTag
- [x] getLinkListByReminder
- [x] getLinkListByTopic
- [x] getLinkListByTasks

## Other
