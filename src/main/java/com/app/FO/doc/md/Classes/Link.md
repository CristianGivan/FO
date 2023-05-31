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


    @Query(nativeQuery = true, value =
            "SELECT * FROM reminder as t inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1,t.reminder_id=?2")
    Reminder getReminderFromUserIdAndReminderId(Long UserId, Long reminderId);
