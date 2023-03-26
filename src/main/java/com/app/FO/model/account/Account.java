package com.app.FO.model.account;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq",
            sequenceName = "account_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "details")
    private String details;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    //todo cum ar trebui sa fac aici  sa fac dou coloane de tranzactii una d din care se cumpara si una din care se vande
    @OneToMany(mappedBy = "account")
    private List<AccountUsers> accountUsers;

    @OneToMany(mappedBy = "account")
    private List<AccountTransaction> accountTransactions;

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", creatorId=" + creator.getId() +
                ", accountUsers=" + accountUsers +
                ", accountTransactions=" + accountTransactions +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<AccountUsers> getAccountUsers() {
        return accountUsers;
    }

    public void setAccountUsers(List<AccountUsers> accountUsers) {
        this.accountUsers = accountUsers;
    }

    public List<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }
}
