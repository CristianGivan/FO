# Todo

## Final check

### Classes

- [14] Account
    - accont expenses account see
- [9] Address
- [16] Dates
- [17] Document
- [18] Email
- [15] Event
- [11] Expense
- [12] Expenses
- [x] Link
- [x] Note
- [20] Person
    - [ ] getPersonPerson check
- [19] PhoneNumber
- [3] Reminder
- [21] Role
- [10] Shop
- [x] Snooze
- [x] Tag
- [6] Task
- [7] Tasks
- [x] Topic
- [13] Transaction
- [x] User
- [8] Work

### General

- [ ] when get a value treat the case when more values are possible
- [ ] topicLink(wishful) or linkTopic (now)

## Old Check

- [ ] 
- [x] when subject already exist throw exception or not?
- [x] accont expenses account see
- [x] getPersonPerosn check
- [ ] dates and phoneNumber dates and number type
- [x] crete entity for address shop document
- [ ] include in accountTransaction and all linked tables als the user for query:  query by user account transaction all
  three
- [ ] when putSubject make sure that there are no other same subject in table
- [x] when get a value treat the case when more values are possible
- [ ] link_date to created_date
- [ ] clarify total price checked price and estimated price how is updated
- [ ] controller for expensesExpense?
- [x] get by user (user is a user from UserList)
- [x] Refactoring all methods to have the same naming conventions
- [x] Check Account
- [x] Check Transaction
- [x] Check Expenses
- [x] Check Expense
- [x] Check Event
- [x] Check Person
- [x] Check Link
- [ ] Check Address
- [ ] Check Document
- [ ] Check Shop
- [ ] Check Work
- [ ] Check Tasks
- [ ] Check Task
- [ ] Check Topic
- [ ] Check Note
- [ ] Check Reminder
- [ ] Check Tag
- [ ] Check User

# Classes

- [ ] CHeck how to proceid use delete userRole from UserRoleservice
  or delete userRole from userRoleList - this second part is better
  because is one interogation fo faind userRole and then can be chacke and not deleter use service

- [ ] create a db local on one drive

- [ ] Resolve DTO mapoper cisrcular dependecis
    1. Create A mapper thta as all Mapers check is is posible to don't use All Services but to inculde them one by one
       in in de mapper
    2. Create in AllServices athe DTO becasue you get stacOverflow if it is User to DTO to create user to DTO
- [ ] addUserListToTag at tagFDTO
- [ ] cehck mapstruct and longbook

- [ ] DTO mapper mapstruct shall be improved shall be used UserRoleDTO or RoleDTO maybe using services
- [ ] @Autowire should be privat public or protected
- [ ] delete isTag isNote
- [ ] check JsonIgnore from creators for classes like tag
- [ ] check that I will have for all the entities : orphanRemoval = true, cascade = {CascadeType.PERSIST,
  CascadeType.MERGE}
- [ ] Understand better security in spring

# Feature

- [ ] brodcast message (check the shopping list I added an item)