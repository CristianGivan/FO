# General


# ToDo

## Entity

- [ ] Add creator (log in user)

### Entity
- [x] Add to all OneToMany the orphanRemoval and cascade
```
, orphanRemoval = true,  cascade = {CascadeType.PERSIST, CascadeType.MERGE}
```

### Service
- [x] putStringToId
  - [1] getLogInUser (userService.getLogInUser())
  - [2] Check if parameter1 (by id) exists (from log in user)
  - [3] Check if record with the parameter1 already exist
  - [4] Add parameter2 in parameter1
  - [5] Save record (entityRepository.save(entity))

- [x] putIdToId
  - [1] getLogInUser (userService.getLogInUser())
  - [2] Check if parameter1 (by id) exists (from log in user)
  - [3] Check if parameter2 (by id) exists (from log in user)
  - [4] Check if parameter1 has parameter2 (serviceAll.getParameter1Parameter2)
  - [5] Create a parameter1Parameter2 record in linking table
  - [6] Add parameter2 in parameter1 list (.getParameter1Parameter2List.set)
  - [7] Save record (entityRepository.save(entity))


### Post
- [x] postTopic
  - [x] getLogInUser (userService.getLogInUser())
  - [x] Check if record with the param1 already exist
  - [x] Create an entity
  - [x] Create an entityUser
  - [x] Save record
  

### Put
- [x] putSubjectToTopic
- [x] putUserToTopic
- [x] putTagToTopic
- [x] putNoteToTopic
- [x] putReminderToTopic


### Get
- [ ] getTopicByTopicSubject
- [ ] getTopicByNoteUser
- [ ] getTopicByTag
- [ ] getTopicByNote
- [ ] getTopicByNoteReminder


### Delete
- [ ] deleteUserFromTopic
- [ ] deleteTagFromTopic
- [ ] deleteNoteFromTopic
- [ ] deleteReminderFromTopic
- [ ] deleteTopic

### Classes
DTO
- [ ] Create DTO and FDTO


User
- [ ] putTopicToUser
- [ ] getUserByTopic
- [ ] deleteTopicFromUser

Tag
- [ ] putTopicToTag
- [ ] getTagByTopic
- [ ] deleteTopicFromTag

Note
- [ ] putTopicToNote
- [ ] getNoteByTopic
- [ ] deleteTopicFromNote

Reminder
- [ ] putTopicToReminder
- [ ] getReminderByTopic
- [ ] deleteTopicFromReminder

## Other
