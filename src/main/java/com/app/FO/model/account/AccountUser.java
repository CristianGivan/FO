package com.app.FO.model.account;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_user")
public class AccountUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_user_seq")
    @SequenceGenerator(name = "account_user_seq",
            sequenceName = "account_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @Column(name = "account_date")
    private LocalDateTime accountDate;

    public AccountUser() {
    }

    public AccountUser(Account account, User user) {
        this.user = user;
        this.account = account;
        this.accountDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AccountTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
