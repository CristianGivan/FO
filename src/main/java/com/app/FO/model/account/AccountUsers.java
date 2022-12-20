package com.app.FO.model.account;

//import com.app.FO.model.expenseslist.ExpensesList;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_users")
public class AccountUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_users_seq")
    @SequenceGenerator(name = "account_users_seq",
            sequenceName = "account_users_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_users_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public AccountUsers() {
    }

    @Override
    public String toString() {
        return "AccountUsers{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", accountId=" + account.getId() +
                ", linkDate=" + linkDate +
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

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
