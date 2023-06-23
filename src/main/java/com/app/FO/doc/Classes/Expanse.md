# General

- in linking table shall be also the check
- the estimationPrice is unit price * quantity but if there are not found it toked the mean values

# ToDo

## FrontEnd

- [ ] after the payment was done from uncheck items a new list had to be created

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

- [x] expense
- [x] product
- [x] subject
- [x] check
- [x] quantity
- [x] unitPrice
- [x] totalPrice
- [x] estimatedPrice
- [x] checkDate
- [x] createdDate
- [x] creator
- [x] expenseUserList
- [x] expenseTagList
- [x] expenseReminderList
- [x] expenseTopicList
- [x] expenseTasksList

### Post

- [ ] postExpense

### Put

- [ ] putSubjectToExpense
- [ ] putTypeToExpense
- [ ] putMarkedPriceToExpense
- [ ] putTotalPriceToExpense
- [ ] putShopToExpense
- [ ] putUserToExpense
- [ ] putTagToExpense
- [ ] putReminderToExpense
- [ ] putTopicToExpense
- [ ] putTasksToExpense
- [ ] putAccountToExpense
- [ ] putPayerToExpense

### Delete

- [ ] deleteUserFromExpense
- [ ] deleteTagFromExpense
- [ ] deleteReminderFromExpense
- [ ] deleteTopicFromExpense
- [ ] deleteTasksFromExpense
- [ ] deleteExpense
- [ ] deletePayerFromExpense

### Get

- [ ] getAllExpense
- [ ] getExpenseById
- [ ] getTaskBySubject
- [ ] getTaskListBySubjectContains
- [ ] getExpenseByType
- [ ] getExpenseByMarkedPrice
- [ ] getExpenseByTotalPrice
- [ ] getExpenseByShop
- [ ] getExpenseByCreatedDate
- [ ] getExpenseListByUser
- [ ] getExpenseListByTag
- [ ] getExpenseListByReminder
- [ ] getExpenseListByTopic
- [ ] getExpenseListByTasks
- [ ] getExpenseListByAccount
- [ ] getExpenseListByPayer

## Other
