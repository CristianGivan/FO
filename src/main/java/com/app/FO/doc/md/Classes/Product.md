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
- [ ] meanQuantity
- [ ] meanUnitPrice
- [ ] quantityList
- [ ] unitPriceList
- [ ] createdDate
- [ ] creator
- [ ] expenseUserList
- [ ] expenseTagList
- [ ] expenseReminderList
- [ ] expenseTopicList
- [ ] expenseTasksList
- [ ] expenseHistoryList

### Post

- [ ] postExpense

### Put

- [ ] putSubjectToExpense
- [ ] putCategoryToExpense
- [ ] putQuantityToExpense
- [ ] putUnitPriceToExpense
- [ ] putTotalPriceToExpense
- [ ] putUserToExpense
- [ ] putTagToExpense
- [ ] putReminderToExpense
- [ ] putTopicToExpense
- [ ] putTasksToExpense

### Delete

- [ ] deleteUserFromExpense
- [ ] deleteTagFromExpense
- [ ] deleteReminderFromExpense
- [ ] deleteTopicFromExpense
- [ ] deleteTasksFromExpense
- [ ] deleteExpense

### Get

- [ ] getAllExpense
- [ ] getExpenseById
- [ ] getTaskBySubject
- [ ] getTaskListBySubjectContains
- [ ] getExpenseByCategory
- [ ] getExpenseByQuantity
- [ ] getExpenseByUnitPrice
- [ ] getExpenseByTotalPrice
- [ ] getExpenseByCreatedDate
- [ ] getExpenseListByUser
- [ ] getExpenseListByTag
- [ ] getExpenseListByReminder
- [ ] getExpenseListByTopic
- [ ] getExpenseListByTasks

## Other
