# General


# ToDo

## Template
### Entity
- [x] Add to all OneToMany the orphanRemoval and cascade
```
, orphanRemoval = true,  cascade = {CascadeType.PERSIST, CascadeType.MERGE}
```

### Post
- [x] postTopic
  - [x] getLogInUser (userService.getLogInUser())
  - [x] Check if record with the param1 already exist
  - [x] Create an entity
  - [x] Create an entityUser
  - [x] Save record

### Put
- [ ] putTopicTextToTopic
- [ ] putUserToTopic
- [ ] putTagToTopic
- [ ] putNoteToTopic
- [ ] putReminderToTopic


### Get
- [ ] getTopicByTopicText
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
