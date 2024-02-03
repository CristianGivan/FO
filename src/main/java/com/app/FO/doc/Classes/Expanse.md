# General

- the estimationPrice is unit price * quantity but if there are not found it toked the mean values
- when a expense is created is neeaded the subject the product if is in a bux or by item will be added after
-

# ToDo

- [ ] One to Many to product to be investigated more
- [ ] operations shall be done

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
- [x] check
- [x] subject
- [x] category
- [x] quantity
- [x] unitPrice
- [x] totalPrice
- [x] estimatedTotalPrice
- [x] checkDate
- [x] createdDate
- [x] creator
- [x] expenseUserList
- [x] expenseTagList
- [x] expenseReminderList
- [x] expenseTopicList
- [x] expenseTasksList

### Post

- [x] postExpense

### Put

- [x] putCheckedToExpense
- [x] putSubjectToExpense
- [x] putCategoryToExpense
- [x] putQuantityToExpense
- [x] putUnitPriceToExpense
- [x] putTotalPriceToExpense
- [x] putCheckedDateToExpense
- [x] putUserToExpense
- [x] putTagToExpense
- [x] putReminderToExpense
- [x] putTopicToExpense
- [x] putTasksToExpense
- [x] putProductToExpense

### Delete

- [x] deleteUserFromExpense
- [x] deleteTagFromExpense
- [x] deleteReminderFromExpense
- [x] deleteTopicFromExpense
- [x] deleteTasksFromExpense
- [x] deleteProductFromExpense

### Get

- [x] getAllExpense
- [x] getExpenseById
- [x] getExpenseListByChecked
- [x] getExpenseListBySubject
- [x] getExpenseListBySubjectContains
- [x] getExpenseListByCategory
- [x] getExpenseListByCategoryContains
- [x] getExpenseListByQuantity
- [x] getExpenseListByQuantityBetween
- [x] getExpenseListByUnitPrice
- [x] getExpenseListByUnitPriceBetween
- [x] getExpenseListByTotalPrice
- [x] getExpenseListByTotalPriceBetween
- [x] getExpenseListByEstimatedTotalPrice
- [x] getExpenseListByEstimatedTotalPriceBetween
- [x] getExpenseByCheckedDate
- [x] getExpenseByCheckedDateBetween
- [x] getExpenseByCreatedDate
- [x] getExpenseByCreatedDateBetween
- [x] getExpenseListByUser
- [x] getExpenseListByTag
- [x] getExpenseListByReminder
- [x] getExpenseListByTopic
- [x] getExpenseListByTasks
- [x] getExpenseListByProduct

## Other
