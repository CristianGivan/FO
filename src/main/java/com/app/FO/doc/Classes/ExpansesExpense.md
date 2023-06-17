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

- [x] expenses
- [x] expense
- [x] check
- [x] unit
- [x] quantity
- [x] unitPrice
- [x] totalPrice
- [x] estimatedPrice
- [x] createdDate
- [x] creator

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
- [ ] putPayerToExpenses

### Delete

- [ ] deleteUserFromExpenses
- [ ] deleteTagFromExpenses
- [ ] deleteReminderFromExpenses
- [ ] deleteTopicFromExpenses
- [ ] deleteTasksFromExpenses
- [ ] deleteExpenses
- [ ] deletePayerFromExpenses

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
- [ ] getExpensesListByPayer

## Other
