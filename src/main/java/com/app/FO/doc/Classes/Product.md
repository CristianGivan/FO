# General

- from time to time the mean can be calculated as ponderat mean for a more relabel mean
- every time when an productsProduct is created than numberOfBuys is increased
- every time when productsProduct is updated check the
- shall be created a oneToOne relation with productStatistic
- subject is name (unit)
- the following are create update by expense
    - [ ] putNumberOfBuysToProduct
    - [ ] putNumberForMeanQuantityToProduct
    - [ ] putNumberForMeanPriceToProduct
    - [ ] putMeanQuantityToProduct
    - [ ] putMeanUnitPriceToProduct
-

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

- [x] subject
- [x] name
- [x] unit
- [x] category
- [x] producer
- [x] numberOfBuys
- [x] numberForMeanQuantity
- [x] numberForMeanPrice
- [x] meanQuantity
- [x] meanUnitPrice
- [x] createdDate
- [x] creator
- [x] productUserList
- [x] productTagList
- [x] productReminderList
- [x] productTopicList
- [x] productTasksList
- [x] productsExpenseList
- [x] productHistoryList

### Post

- [ ] postProduct

### Put

- [ ] putNameToProduct
- [ ] putUnitToProduct
- [ ] putCategoryToProduct
- [ ] putProducerToProduct
- [ ] putUserToProduct
- [ ] putTagToProduct
- [ ] putReminderToProduct
- [ ] putTopicToProduct
- [ ] putTasksToProduct
- [ ] putExpenseToProduct

### Delete

- [ ] deleteUserFromProduct
- [ ] deleteTagFromProduct
- [ ] deleteReminderFromProduct
- [ ] deleteTopicFromProduct
- [ ] deleteTasksFromProduct
- [ ] deleteExpenseFromProduct
- [ ] deleteProduct

### Get

- [ ] getAllProduct
- [ ] getProductById
- [ ] getProductBySubject
- [ ] getProductListBySubjectContains
- [ ] getProductByName
- [ ] getProductListByNameContains
- [ ] getProductByUnit
- [ ] getProductByCategory
- [ ] getProductListByCategoryContains
- [ ] getProductListByUnitContains
- [ ] getProductByProducer
- [ ] getProductListByProducerContains
- [ ] getProductByNumberOfBuys
- [ ] getProductListByNumberOfBuysBetween
- [ ] getProductByNumberForMeanQuantity
- [ ] getProductListByNumberForMeanQuantityBetween
- [ ] getProductByNumberForMeanPrice
- [ ] getProductListByNumberForMeanPriceBetween
- [ ] getProductByMeanQuantity
- [ ] getProductListByMeanQuantityBetween
- [ ] getProductByMeanUnitPrice
- [ ] getProductListByMeanUnitPriceBetween
- [ ] getProductByCreatedDate
- [ ] getProductListByCreatedDateBetween
- [ ] getProductListByUser
- [ ] getProductListByTag
- [ ] getProductListByReminder
- [ ] getProductListByTopic
- [ ] getProductListByTasks

## Other
