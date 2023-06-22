# General

- type buy sell borrow receive
- the balance will be updated when a transaction si added or when an expence is added
- [ ] putBalanceToAccount is done by expenses and transaction
- [ ] during modifi balance check if the balance is negative mabe add methods as add to balance substract to balance
- [ ] a currency shall be added to the account shall be considered also conversion rate

# ToDo

- [ ] putExpensesToAccount is done at expenses?
- [ ] putTransactionToAccount is done at transaction?

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
- [x] balance
- [x] expensesList
- [x] transactionList
- [x] createdDate
- [x] creator
- [x] accountUserList
- [x] accountTagList
- [x] accountReminderList
- [x] accountTopicList
- [x] accountTasksList
- [x] accountHistoryList

### Post

- [x] postAccount

### Put

- [x] putSubjectToAccount
- [x] putTypeToAccount
- [x] putCreatedDateToAccount
- [x] putUserToAccount
- [x] putTagToAccount
- [x] putReminderToAccount
- [x] putTopicToAccount
- [x] putTasksToAccount
- [x] putExpensesToAccount
- [x] putTransactionFromAccountToAccount

### Delete

- [] deleteUserFromAccount
- [] deleteTagFromAccount
- [] deleteReminderFromAccount
- [] deleteTopicFromAccount
- [] deleteTasksFromAccount
- [] deleteExpensesFromAccount
- [] deleteTransactionFromAccount
- [] deleteAccount

### Get

- [x] getAllAccount
- [x] getAccountById
- [x] getAccountBySubject
- [x] getAccountListBySubjectContains
- [x] getAccountByType
- [x] getAccountByTypeContains
- [x] getAccountByBalance
- [x] getAccountByBalanceBetween
- [x] getAccountByCreatedDate
- [x] getAccountByCreatedDateBetween
- [x] getAccountListByUser
- [x] getAccountListByTag
- [x] getAccountListByReminder
- [x] getAccountListByTopic
- [x] getAccountListByTasks
- [x] getAccountListByExpenses
- [x] getAccountListByTransaction
- [x] getAccountListByTransactionWithDirection
- [x] getAccountListByTransactionDirection

## Other

- [ ] delete putCretedDate