# General

# ToDo

## Entity

- [x] Add creator (log in user)
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

- [x] Add to all OneToMany the orphanRemoval and cascade

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
- [x] creator
- [x] topicUserList
- [x] topicTagList
- [x] topicReminderList
- [x] topicNoteList

### Post

- [x] postTopic

### Put

- [x] putSubjectToTopic
- [x] putUserToTopic
- [x] putNoteToTopic
- [x] putTagToTopic
- [x] putReminderToTopic
- [ ] putLinkToTopic

### Delete

- [x] deleteUserFromTopic
- [x] deleteNoteFromTopic
- [x] deleteTagFromTopic
- [x] deleteReminderFromTopic
- [ ] deleteLinkFromTopic
- [x] deleteTopic

### Get

- [x] getAllTopic
- [x] getTopicBySubject
- [x] getTopicListBySubjectContains
- [x] getTopicByTopicId
- [x] getTopicListByNoteId
- [x] getTopicListByTagId
- [x] getTopicListByReminderId
- [ ] getTopicListByLink

## Other

- [ ] shall have link or not?