# General

- type buy sell borrow receive

# ToDo

- [ ] putSum update also the balance from accounts
- [ ] putaccount update deleted the accountTransaction to be moved to history

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
- [x] creator
- [x] transactionUserList
- [x] transactionTagList
- [x] transactionReminderList
- [x] transactionTopicList
- [x] transactionTasksList
- [x] accountTransactionList
- [x] transactionHistoryList

- 
### Post

- [x] postTransaction

### Put

- [x] putSubjectToTransaction
- [x] putTypeToTransaction
- [x] putSumToTransaction
- [x] putUserToTransaction
- [x] putTagToTransaction
- [x] putReminderToTransaction
- [x] putTopicToTransaction
- [x] putTasksToTransaction
- [x] putAccountToTransaction

### Delete

- [ ] deleteUserFromTransaction
- [ ] deleteTagFromTransaction
- [ ] deleteReminderFromTransaction
- [ ] deleteTopicFromTransaction
- [ ] deleteTasksFromTransaction
- [ ] deleteTransaction

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
- [x] getTransactionListByUser
- [x] getTransactionListByTag
- [x] getTransactionListByReminder
- [x] getTransactionListByTopic
- [x] getTransactionListByTasks
- [x] getTransactionListByAccountByDirection

## Other
