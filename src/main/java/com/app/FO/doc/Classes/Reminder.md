Ideas:

- A reminder can be assigned only to one other class or o a parent class and the User ex Note or Topic and User
  if you delete the reminder because it was expired it was deleted only for the purpose was created not also from other
  class Task
- traete this assign of one reminder to many entities (e.g. tasks)
- [ ] Add creator (log in user)
- shall have a user list?
- un reminder poate sa aiba mai multe entitati si o entitate poate sa aimba mai multe reminder dar se sterge doar
  relatia dintre entitate si reminder cand reminderul este oprit de la o entitate mai mult decat atat nu se sterge se
  muta in history

## ToDo

- [ ] clarify the relation ReminderReminder check deletion

### Attributes

- [x] subject
- [x] reminderDateTime
- [x] createdDate
- [x] creator
- [x] reminderUserList
- [x] snooze
- [x] reminderList

### Post

- [x] postReminder

### Put

- [x] putSubjectToReminder
- [x] putReminderDateTimeToReminder
- [x] putUserToReminder
- [x] putSnoozeToReminder
- [x] putReminderToReminder

### Delete

- [x] deleteUserFromReminder
- [x] deleteSnoozeFromReminder
- [x] deleteReminderFromReminder
- [ ] deleteReminder

### Get

- [x] getAllReminder
- [x] getReminderById
- [x] getReminderBySubject
- [x] getReminderListBySubjectContains
- [x] getReminderByReminderDateTime
- [x] getReminderByReminderDateTimeBetween
- [x] getReminderByCreatedDate
- [x] getReminderListByCreatedDateBetween
- [x] getReminderListByUser
- [x] getReminderListBySnooze
- [x] getReminderListWithReminder
- [x] getReminderListFromReminder