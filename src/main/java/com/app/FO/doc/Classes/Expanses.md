# General

- type is if is a shopping list, wish list
- the user is a person that use the application
- the payer is a person that can have a user or not
- in linking table shall be also the check
- the list is close when the paymentDate is set
- after closing the list if the quantity and unit price is fill the numberForMean is increased otherwise only the
  numberOfBuys
- After the list is closed the another list with expenses that were not checked shall be created
- tag reminder and other are not from expense to dont confuse with the one addes only for expenses but them can be seen
  in front end from expense
- tag reminder and other when a new expanses is created after closing it should be asked if the other shall be puted to
  new list
- there is a check in expense that mean that at list in one expenses there is checked
  and there is a check in expensesExpense where in that expense list is checked

# ToDo

- create and link shop entity
- private void payedCheckedExpensesAccount(Expenses expenses)
- private void refundCheckedExpensesAccount(Expenses expenses)
-

## Feature

- [ ] check how to treat the if the list is reopened to adjustments

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

- [x] subject
- [x] type
- [x] expensesStatus
- [x] expensesNumber
- [x] checkedNumber
- [x] totalPrice
- [x] estimatedTotalPrice
- [x] checkedPrice
- [x] payedDate
- [x] createdDate
- [x] creator
- [x] expensesUserList
- [x] expensesTagList
- [x] expensesReminderList
- [x] expensesTopicList
- [x] expensesTasksList
- [x] expensesExpenseList
- [x] expensesPersonList
- [x] Shop
- [x] expensesAccountList
- [x] expensesHistoryList

### Post

- [x] postExpenses

### Put

- [x] putSubjectToExpenses
- [x] putTypeToExpenses
- [x] putExpensesStatusToExpenses
- [x] putPayedDateToExpenses
- [x] putUserToExpenses
- [x] putTagToExpenses
- [x] putReminderToExpenses
- [x] putTopicToExpenses
- [x] putTasksToExpenses
- [x] putExpenseToExpenses
- [x] putCheckedToExpenseToExpenses
- [x] putPersonToExpenses
- [x] putShopToExpenses
- [x] putAccountToExpenses
- [x] putAccountToExpensesWithAmount

### Delete

- [x] deleteUserFromExpenses
- [x] deleteTagFromExpenses
- [x] deleteReminderFromExpenses
- [x] deleteTopicFromExpenses
- [x] deleteTasksFromExpenses
- [x] deletePersonFromExpenses
- [x] deleteShopFromExpenses
- [x] deleteExpenseFromExpenses
- [x] deleteAccountFromExpenses
- [x] deleteExpenses

### Get

- [x] getAllExpenses
- [x] getExpensesById
- [x] getExpensesListBySubject
- [x] getExpensesListBySubjectContains
- [x] getExpensesListByType
- [x] getExpensesListByTypeContains
- [x] getExpensesListByExpensesStatus
- [x] getExpensesListByExpenseNumber
- [x] getExpensesListByExpenseNumberBetween
- [x] getExpensesListByCheckedNumber
- [x] getExpensesListByCheckedNumberBetween
- [x] getExpensesListByTotalPrice
- [x] getExpensesListByTotalPriceBetween
- [x] getExpensesListByEstimatedTotalPrice
- [x] getExpensesListByEstimatedTotalPriceBetween
- [x] getExpensesListByCheckedPrice
- [x] getExpensesListByCheckedPriceBetween
- [x] getExpensesListByPayedDate
- [x] getExpensesListByPayedDateBetween
- [x] getExpensesByCreatedDate
- [x] getExpensesListByCreatedDateBetween
- [x] getExpensesListByUser
- [x] getExpensesListByTag
- [x] getExpensesListByReminder
- [x] getExpensesListByTopic
- [x] getExpensesListByTasks
- [x] getExpensesListByExpense
- [x] getExpensesListByPerson
- [x] getExpensesByShopId
- [x] getExpensesListByAccount

## Other
