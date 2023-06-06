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

# ToDo

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
- [x] shop
- [x] estimatedTotalPrice
- [x] checkedPrice
- [x] totalPrice
- [x] payedDate
- [x] createdDate
- [x] creator
- [x] expensesUserList
- [x] expensesTagList
- [x] expensesReminderList
- [x] expensesTopicList
- [x] expensesTasksList
- [x] expensesExpenseList
- [x] expensesPayerList
- [x] accountExpensesList
- [x] expensesHistoryList

### Post

- [ ] postExpenses

### Put

- [ ] putSubjectToExpenses
- [ ] putTypeToExpenses
- [ ] putShopToExpenses
- [ ] putPayedDateToExpenses
- [ ] putUserToExpenses
- [ ] putTagToExpenses
- [ ] putReminderToExpenses
- [ ] putTopicToExpenses
- [ ] putTasksToExpenses
- [ ] putExpenseToExpenses
- [ ] putPayerToExpenses
- [ ] putAccountToExpenses

### Delete

- [ ] deleteUserFromExpenses
- [ ] deleteTagFromExpenses
- [ ] deleteReminderFromExpenses
- [ ] deleteTopicFromExpenses
- [ ] deleteTasksFromExpenses
- [ ] deleteExpenseFromExpenses
- [ ] deletePayerFromExpenses
- [ ] deleteAccountFromExpenses
- [ ] deleteExpenses

### Get

- [ ] getAllExpenses
- [ ] getExpensesById
- [ ] getExpensesBySubject
- [ ] getExpensesListBySubjectContains
- [ ] getExpensesByType
- [ ] getExpensesListByTypeContains
- [ ] getExpensesByCheckedPrice
- [ ] getExpensesListByCheckedPriceBetween
- [ ] getExpensesByTotalPrice
- [ ] getExpensesListByTotalPriceBetween
- [ ] getExpensesByShop
- [ ] getExpensesByShopContains
- [ ] getExpensesByCreatedDate
- [ ] getExpensesListByCreatedDateBetween
- [ ] getExpensesListByUser
- [ ] getExpensesListByTag
- [ ] getExpensesListByReminder
- [ ] getExpensesListByTopic
- [ ] getExpensesListByTasks
- [ ] getExpensesListByExpense
- [ ] getExpensesListByAccount
- [ ] getExpensesListByPayer

## Other
