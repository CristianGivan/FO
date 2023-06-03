package com.app.FO.model.account;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_tasks")
public class AccountTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_tasks_seq")
    @SequenceGenerator(name = "account_tasks_seq",
            sequenceName = "account_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @Column(name = "account_date")
    private LocalDateTime accountDate;

    public AccountTasks() {
    }

    public AccountTasks(Account account, Tasks tasks) {
        this.account = account;
        this.tasks = tasks;
        this.accountDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AccountTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
                ", account=" + account.getId() +
                ", accountDate=" + accountDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(LocalDateTime accountDate) {
        this.accountDate = accountDate;
    }
}
