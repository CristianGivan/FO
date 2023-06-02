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
- [ ] category
- [ ] quantity
- [ ] unitPrice
- [ ] totalPrice
- [ ] shop
- [ ] createdDate
- [ ] creator
- [ ] linkUserList
- [ ] linkTagList
- [ ] linkReminderList
- [ ] linkTopicList
- [ ] linkTasksList
- [ ] account
- [ ] linkHistoryList

### Post

- [ ] postLink

### Put

- [ ] putSubjectToLink
- [ ] putCategoryToLink
- [ ] putQuantityToLink
- [ ] putUnitPriceToLink
- [ ] putTotalPriceToLink
- [ ] putShopToLink
- [ ] putUserToLink
- [ ] putTagToLink
- [ ] putReminderToLink
- [ ] putTopicToLink
- [ ] putTasksToLink
- [ ] putAccountToLink

### Delete

- [ ] deleteUserFromLink
- [ ] deleteTagFromLink
- [ ] deleteReminderFromLink
- [ ] deleteTopicFromLink
- [ ] deleteTasksFromLink
- [ ] deleteLink

### Get

- [ ] getAllLink
- [ ] getLinkById
- [ ] getTaskBySubject
- [ ] getTaskListBySubjectContains
- [ ] getLinkByCategory
- [ ] getLinkByQuantity
- [ ] getLinkByUnitPrice
- [ ] getLinkByTotalPrice
- [ ] getLinkByShop
- [ ] getLinkByCreatedDate
- [ ] getLinkListByUser
- [ ] getLinkListByTag
- [ ] getLinkListByReminder
- [ ] getLinkListByTopic
- [ ] getLinkListByTasks
- [ ] getLinkListByAccount

## Other
