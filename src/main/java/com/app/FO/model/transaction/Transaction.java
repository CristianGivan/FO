package com.app.FO.model.transaction;

import com.app.FO.model.account.AccountTransaction;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    @SequenceGenerator(name = "transaction_seq",
            sequenceName = "transaction_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "transaction_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "type")
    private String type;
    @Column(name = "sum")
    private Double sum;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;
    @OneToMany(mappedBy = "transaction", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TransactionUser> transactionUserList;

    @OneToMany(mappedBy = "transaction", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TransactionTag> transactionTagList;

    @OneToMany(mappedBy = "transaction", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TransactionReminder> transactionReminderList;

    @OneToMany(mappedBy = "transaction", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TransactionTopic> transactionTopicList;

    @OneToMany(mappedBy = "transaction", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TransactionTasks> transactionTasksList;

    @OneToMany(mappedBy = "transaction", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountTransaction> accountTransactionList;

    @OneToMany(mappedBy = "transaction", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TransactionHistory> transactionHistoryList;

    public Transaction() {
    }

    //todo add from here also account transaction
    public Transaction(String subject, User creator, Double sum) {
        this.subject = subject;
        this.creator = creator;
        this.sum = sum;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", transactionUserList=" + transactionUserList +
                ", transactionTopicList=" + transactionTopicList +
                ", transactionTasksList=" + transactionTasksList +
                ", transactionUserList=" + transactionUserList +
                ", transactionTagList=" + transactionTagList +
                ", transactionReminderList=" + transactionReminderList +
                ", fromAccount=" + accountTransactionList +
                ", toAccount=" + accountTransactionList +
                ", transactionHistoryList=" + transactionHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        if (type == null) {
            type = "";
        }
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSum() {
        if (sum == null) {
            sum = 0.0;
        }
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<TransactionUser> getTransactionUserList() {
        if (transactionUserList == null) {
            transactionUserList = new ArrayList<>();
        }
        return transactionUserList;
    }

    public void setTransactionUserList(List<TransactionUser> transactionUserList) {
        this.transactionUserList = transactionUserList;
    }

    public List<TransactionTag> getTransactionTagList() {
        return transactionTagList;
    }

    public void setTransactionTagList(List<TransactionTag> transactionTagList) {
        this.transactionTagList = transactionTagList;
    }

    public List<TransactionReminder> getTransactionReminderList() {
        return transactionReminderList;
    }

    public void setTransactionReminderList(List<TransactionReminder> transactionReminderList) {
        this.transactionReminderList = transactionReminderList;
    }

    public List<TransactionTopic> getTransactionTopicList() {
        return transactionTopicList;
    }

    public void setTransactionTopicList(List<TransactionTopic> transactionTopicList) {
        this.transactionTopicList = transactionTopicList;
    }

    public List<TransactionTasks> getTransactionTasksList() {
        return transactionTasksList;
    }

    public void setTransactionTasksList(List<TransactionTasks> transactionTasksList) {
        this.transactionTasksList = transactionTasksList;
    }

    public List<AccountTransaction> getAccountTransactionList() {
        if (accountTransactionList == null) {
            accountTransactionList = new ArrayList<>();
        }
        return accountTransactionList;
    }

    public void setAccountTransactionList(List<AccountTransaction> accountTransactionList) {
        this.accountTransactionList = accountTransactionList;
    }

    public List<TransactionHistory> getTransactionHistoryList() {
        return transactionHistoryList;
    }

    public void setTransactionHistoryList(List<TransactionHistory> transactionHistoryList) {
        this.transactionHistoryList = transactionHistoryList;
    }

}
