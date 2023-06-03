# General

- type buy sell borrow receive
- the balance will be updated when a transaction si added or when an expence is added

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
- [ ] balance
- [ ] transactionList
- [ ] expensesList
- [ ] createdDate
- [ ] creator
- [ ] accontUserList
- [ ] accontTagList
- [ ] accontReminderList
- [ ] accontTopicList
- [ ] accontTasksList
- [ ] accontHistoryList

### Post

- [ ] postAccont

### Put

- [ ] putSubjectToAccont
- [ ] putTypeToAccont
- [ ] putUserToAccont
- [ ] putTagToAccont
- [ ] putReminderToAccont
- [ ] putTopicToAccont
- [ ] putTasksToAccont
- [ ] putBalanceToAccont
- [ ] putTransactionToAccont
- [ ] putExpensesToAccont

### Delete

- [ ] deleteUserFromAccont
- [ ] deleteTagFromAccont
- [ ] deleteReminderFromAccont
- [ ] deleteTopicFromAccont
- [ ] deleteTasksFromAccont
- [ ] deleteAccont

### Get

- [ ] getAllAccont
- [ ] getAccontById
- [ ] getTaskBySubject
- [ ] getTaskListBySubjectContains
- [ ] getAccontByType
- [ ] getAccontByCreatedDate
- [ ] getAccontListByUser
- [ ] getAccontListByTag
- [ ] getAccontListByReminder
- [ ] getAccontListByTopic
- [ ] getAccontListByTasks
- [ ] getAccontListByBalance
- [ ] getAccontListByTransaction
- [ ] getAccontListByExpenses

## Other
