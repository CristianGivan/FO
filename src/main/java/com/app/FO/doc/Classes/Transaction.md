# General

- type buy sell borrow receive

# ToDo

- [ ] putSum update also the balance from accounts
- [ ] putAccount update deleted the accountTransaction to be moved to history
- deleteAccountFromTransaction is not used because you cannot have a transaction with only one account it chan be only
  changed
- transaction can have status pending planed completed (pending is not used could be that it is the balance is changed
  but the money are not to the recipient)
  done https://support-paypage.ecom-psp.com/en/get-started/transaction-management/transaction-statuses
- UNDEFINE(0),
  CREATED(1),
  PLANED(2),
  PENDING(3),
  COMPLETED(4);
    - first a transaction is created and the status is created waiting to be completed - nothing changed in balance of
      the account
    - a transaction can have status planed where it has a time when it can be done a remainder will be created to this
      date - nothing changed in balance of the account
    - completed balance is updated
- when a transaction is planed or completed calculate if enough money will remain for the planed dates

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
- [x] sum
- [x] createdDate
- [x] planedDate
- [x] completedDate
- [x] transactionStatus
- [x] creator
- [x] transactionUserList
- [x] transactionTagList
- [x] transactionReminderList
- [x] transactionTopicList
- [x] transactionTasksList
- [x] AccountTransactionList
- [x] transactionHistoryList

-

### Post

- [x] postTransaction

### Put

- [x] putSubjectToTransaction
- [x] putTypeToTransaction
- [] putSumToTransaction
- [x] putPlanedDateToTransaction
- [x] putCompletedDateToTransaction
- [x] putTransactionStatusToTransaction
- [x] putUserToTransaction
- [x] putTagToTransaction
- [x] putReminderToTransaction
- [x] putTopicToTransaction
- [x] putTasksToTransaction
- [ ] putAccountToTransaction

### Delete

- [x] deleteUserFromTransaction
- [x] deleteTagFromTransaction
- [x] deleteReminderFromTransaction
- [x] deleteTopicFromTransaction
- [x] deleteTasksFromTransaction
- [x] deleteTransaction

### Get

- [x] getAllTransaction
- [x] getTransactionById
- [x] getTransactionBySubject
- [x] getTransactionListBySubjectContains
- [x] getTransactionByType
- [x] getTransactionListByTypeContains
- [x] getTransactionBySum
- [x] getTransactionListBySumBetween
- [x] getTransactionByCreatedDate
- [x] getTransactionListByCreatedDateBetween
- [x] getTransactionListByPlaned
- [x] getTransactionListByPlanedDateBetween
- [x] getTransactionListByCompleted
- [x] getTransactionListByCompletedDateBetween
- [x] getTransactionListByTransactionStatus
- [x] getTransactionListByUser
- [x] getTransactionListByTag
- [x] getTransactionListByReminder
- [x] getTransactionListByTopic
- [x] getTransactionListByTasks
- [x] getTransactionListByAccountWithDirection

## Other
