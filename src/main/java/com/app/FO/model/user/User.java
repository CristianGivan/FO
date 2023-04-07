package com.app.FO.model.user;


import com.app.FO.exceptions.IdAlreadyAllocatedException;
import com.app.FO.model.account.AccountUser;
import com.app.FO.model.expense.Expense;
//import com.app.FO.model.expenseslist.Expenses;
import com.app.FO.model.expenses.ExpensesUser;
import com.app.FO.model.note.NoteHistory;
import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.task.Task;
import com.app.FO.model.task.TaskHistory;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.tasks.TasksHistory;
import com.app.FO.model.topic.TopicHistory;
import com.app.FO.model.note.Note;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.account.Account;
import com.app.FO.model.topic.TopicUser;
import com.app.FO.model.transaction.Transaction;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq",
            sequenceName = "user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "user_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserRole> userRoleList;


    @OneToMany(mappedBy = "creator",cascade = CascadeType.ALL)
    private List<Topic> topicList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<TopicHistory> topicHistoryList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Note> noteList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<NoteHistory> noteHistoryList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Remainder> remainderList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Task> taskList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<TaskHistory> taskHistoryList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Tasks> tasksList;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<TasksHistory> tasksHistoryList;

    @OneToMany(mappedBy = "creator")
    private List<Expense> expensesCreatedList;

    @OneToMany(mappedBy = "payer")
    private List<Expense> expensesPayedList;


    @OneToMany(mappedBy = "user")
    private List<ExpensesUser> expensesUserList;

    @OneToMany(mappedBy = "creator")
    private List<Account> accountList;

    @OneToMany(mappedBy = "user")
    private List<AccountUser> accountUserList;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactionList;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserTag> userTagList;

    @OneToMany(mappedBy = "user")
    private List<TopicUser> topicUserList;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRoles=" + userRoleList +
                ", userTags=" + userTagList +
                ", topics=" + topicList +
                ", topicHistories=" + topicHistoryList +
                ", notes=" + noteList +
                ", noteHistories=" + noteHistoryList +
                ", remainders=" + remainderList +
                ", tasks=" + tasksList +
                ", taskHistories=" + taskHistoryList +
                ", tasks=" + tasksList +
                ", taskListHistories=" + tasksHistoryList +
                ", expensesCreated=" + expensesCreatedList +
                ", expensesPayed=" + expensesPayedList +
                ", expensesUsers=" + expensesUserList +
                ", accounts=" + accountList +
                ", accountUsers=" + accountUserList +
                ", transactions=" + transactionList +
                '}';
    }

    public User(String username, String password) {
        this.username = username;
        this.password=password;
    }


    public void setId(Long id) {
        if (this.id == null || this.id.equals(id)) {
            this.id = id;
        } else {
            throw new IdAlreadyAllocatedException(
                    "Id is already allocated cannot be changed");
        }
    }
    public List<UserRole> getUserRoleList() {
        if (userRoleList ==null){
            userRoleList =new ArrayList<>();
        }
        return userRoleList;
    }

    public List<UserTag> getUserTagList() {
        if (userTagList ==null){
            userTagList = new ArrayList<>();
        }
        return userTagList;
    }
}
