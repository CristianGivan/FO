# General

- from time to time the mean can be calculated as ponderat mean for a more relabel mean
- every time when an expensesExpense is created than numberOfBuys is increased
- every time when expensesExpense is updated check the
- shall be created a oneToOne relation with expenseStatistic

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

- [x] name
- [x] producer
- [x] subject
- [x] category
- [x] numberOfBuys
- [x] numberForMean
- [x] meanQuantity
- [x] meanUnitPrice
- [x] createdDate
- [x] creator
- [x] expenseUserList
- [x] expenseTagList
- [x] expenseReminderList
- [x] expenseTopicList
- [x] expenseTasksList
- [x] expensesExpenseList
- [x] expenseHistoryList

### Post

- [x] postExpense

### Put

- [x] putNameToExpense
- [x] putProducerToExpense
- [x] putCategoryToExpense
- [ ] putNumberOfBuysToExpense
- [ ] putNumberForMeanToExpense
- [ ] putMeanQuantityToExpense
- [ ] putMeanUnitPriceToExpense
- [ ] putQuantityToExpense
- [ ] putUnitPriceToExpense
- [ ] putTotalPriceToExpense
- [x] putUserToExpense
- [x] putTagToExpense
- [x] putReminderToExpense
- [x] putTopicToExpense
- [ ] putTasksToExpense

### Delete

- [ ] deleteUserFromExpense
- [ ] deleteTagFromExpense
- [ ] deleteReminderFromExpense
- [ ] deleteTopicFromExpense
- [ ] deleteTasksFromExpense
- [ ] deleteExpense

### Get

- [x] getAllExpense
- [x] getExpenseById
- [x] getExpenseByName
- [x] getExpenseListByNameContains
- [x] getExpenseByProducer
- [x] getExpenseListByProducerContains
- [x] getExpenseBySubject
- [x] getExpenseListBySubjectContains
- [x] getExpenseByCategory
- [x] getExpenseListByCategoryContains
- [x] getExpenseByNumberOfBuys
- [x] getExpenseListByNumberOfBuysBetween
- [x] getExpenseByNumberForMean
- [x] getExpenseListByNumberForMeanBetween
- [x] getExpenseByMeanQuantity
- [x] getExpenseListByMeanQuantityBetween
- [x] getExpenseByMeanUnitPrice
- [x] getExpenseListByMeanUnitPriceBetween
- [x] getExpenseByCreatedDate
- [x] getExpenseListByCreatedDateBetween
- [x] getExpenseListByUser
- [x] getExpenseListByTag
- [x] getExpenseListByReminder
- [x] getExpenseListByTopic
- [x] getExpenseListByTasks

## Other
