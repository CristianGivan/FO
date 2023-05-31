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
- [ ] createdDate
- [ ] creator
- [ ] userList
- [ ] linkTagList
- [ ] linkReminderList
- [ ] linkTopicList
- [ ] linkTaskList
- [ ] linkHistoryList

### Post

- [ ] postLink

### Put

- [ ] putSubjectToLink
- [ ] putUserToLink
- [ ] putTagToLink
- [ ] putReminderToLink
- [ ] putTopicToLink
- [ ] putTaskToLink

### Delete

- [ ] deleteUserFromLink
- [ ] deleteTagFromLink
- [ ] deleteReminderFromLink
- [ ] deleteTopicFromLink
- [ ] deleteTaskFromLink
- [ ] deleteLink

### Get

- [ ] getAllLink
- [ ] getLinkById
- [ ] getLinkByLinkingDate
- [ ] getLinkByLinkingTime
- [ ] getLinkByUser
- [ ] getLinkListByTag
- [ ] getLinkListByReminder
- [ ] getLinkListByTopic
- [ ] getLinkListByTask

## Other
