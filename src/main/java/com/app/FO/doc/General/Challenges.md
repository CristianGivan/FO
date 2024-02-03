- find the right query

```
   "SELECT * FROM reminder as t inner join reminder_reminder as tt on t.reminder_id = tt.reminder_id inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1 and tt.reminder_id=?2")
   "SELECT * FROM reminder as r inner join (SELECT tt.repeated_reminder_id FROM reminder as t inner join reminder_reminder as tt on t.reminder_id = tt.reminder_id inner join reminder_user tu on t.reminder_id = tu.reminder_id where tu.user_id=?1 and tt.reminder_id=?2) as ri where ri.repeated_reminder_id=r.reminder_id")
```

- find the right relation
    - reminder
- to be as consistent much as possible
- to create systems/reminders where I was and what shall I do next because I was interrupted often  