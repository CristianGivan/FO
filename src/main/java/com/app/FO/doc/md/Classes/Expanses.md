# General

- type is if is a shopping list, wish list

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
- [ ] type
- [ ] markedPrice
- [ ] totalPrice
- [ ] shop
- [ ] createdDate
- [ ] creator
- [ ] expensesUserList
- [ ] expensesTagList
- [ ] expensesReminderList
- [ ] expensesTopicList
- [ ] expensesTasksList
- [ ] account
- [ ] expensesHistoryList

### Post

- [ ] postExpenses

### Put

- [ ] putSubjectToExpenses
- [ ] putTypeToExpenses
- [ ] putMarkedPriceToExpenses
- [ ] putTotalPriceToExpenses
- [ ] putShopToExpenses
- [ ] putUserToExpenses
- [ ] putTagToExpenses
- [ ] putReminderToExpenses
- [ ] putTopicToExpenses
- [ ] putTasksToExpenses
- [ ] putAccountToExpenses

### Delete

- [ ] deleteUserFromExpenses
- [ ] deleteTagFromExpenses
- [ ] deleteReminderFromExpenses
- [ ] deleteTopicFromExpenses
- [ ] deleteTasksFromExpenses
- [ ] deleteExpenses

### Get

- [ ] getAllExpenses
- [ ] getExpensesById
- [ ] getTaskBySubject
- [ ] getTaskListBySubjectContains
- [ ] getExpensesByType
- [ ] getExpensesByMarkedPrice
- [ ] getExpensesByTotalPrice
- [ ] getExpensesByShop
- [ ] getExpensesByCreatedDate
- [ ] getExpensesListByUser
- [ ] getExpensesListByTag
- [ ] getExpensesListByReminder
- [ ] getExpensesListByTopic
- [ ] getExpensesListByTasks
- [ ] getExpensesListByAccount

## Other
