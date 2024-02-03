package com.app.FO.model.expenses;

import com.app.FO.model.account.AccountExpenses;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_seq")
    @SequenceGenerator(name = "expenses_seq",
            sequenceName = "expenses_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_id")
    private Long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "type")
    private String type;

    @Column(name = "shop")
    private String shop;

    @Column(name = "estimatedTotalPrice")
    private Double estimatedTotalPrice;

    @Column(name = "checkedPrice")
    private Double checkedPrice;

    @Column(name = "totalPrice")
    private Double totalPrice;

    @Column(name = "payedDate")
    private LocalDateTime payedDate;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;
    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesUser> expensesUserList;

    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesTag> expensesTagList;

    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesReminder> expensesReminderList;

    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesTopic> expensesTopicList;

    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesTasks> expensesTasksList;

    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesExpense> expensesExpenseList;

    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesPerson> expensesPersonList;

    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountExpenses> accountExpensesList;
    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesHistory> expensesHistoryList;


    public Expenses() {
    }

    public Expenses(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", type='" + type + '\'' +
                ", shop='" + shop + '\'' +
                ", estimatedTotalPrice=" + estimatedTotalPrice +
                ", checkedPrice=" + checkedPrice +
                ", totalPrice=" + totalPrice +
                ", payedDate=" + payedDate +
                ", createdDate=" + createdDate +
                ", creator=" + creator.getId() +
                ", expensesUserList=" + expensesUserList +
                ", expensesTagList=" + expensesTagList +
                ", expensesReminderList=" + expensesReminderList +
                ", expensesTopicList=" + expensesTopicList +
                ", expensesTasksList=" + expensesTasksList +
                ", expensesExpenseList=" + expensesExpenseList +
                ", expensesPayerList=" + expensesPersonList +
                ", accountExpensesList=" + accountExpensesList +
                ", expensesHistoryList=" + expensesHistoryList +
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
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public Double getEstimatedTotalPrice() {
        return estimatedTotalPrice;
    }

    public void setEstimatedTotalPrice(Double estimatedTotalPrice) {
        this.estimatedTotalPrice = estimatedTotalPrice;
    }

    public Double getCheckedPrice() {
        return checkedPrice;
    }

    public void setCheckedPrice(Double checkedPrice) {
        this.checkedPrice = checkedPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getPayedDate() {
        return payedDate;
    }

    public void setPayedDate(LocalDateTime payedDate) {
        this.payedDate = payedDate;
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

    public List<ExpensesUser> getExpensesUserList() {
        return expensesUserList;
    }

    public void setExpensesUserList(List<ExpensesUser> expensesUserList) {
        this.expensesUserList = expensesUserList;
    }

    public List<ExpensesTag> getExpensesTagList() {
        return expensesTagList;
    }

    public void setExpensesTagList(List<ExpensesTag> expensesTagList) {
        this.expensesTagList = expensesTagList;
    }

    public List<ExpensesReminder> getExpensesReminderList() {
        return expensesReminderList;
    }

    public void setExpensesReminderList(List<ExpensesReminder> expensesReminderList) {
        this.expensesReminderList = expensesReminderList;
    }

    public List<ExpensesTopic> getExpensesTopicList() {
        return expensesTopicList;
    }

    public void setExpensesTopicList(List<ExpensesTopic> expensesTopicList) {
        this.expensesTopicList = expensesTopicList;
    }

    public List<ExpensesTasks> getExpensesTasksList() {
        return expensesTasksList;
    }

    public void setExpensesTasksList(List<ExpensesTasks> expensesTasksList) {
        this.expensesTasksList = expensesTasksList;
    }

    public List<ExpensesExpense> getExpensesExpenseList() {
        return expensesExpenseList;
    }

    public void setExpensesExpenseList(List<ExpensesExpense> expensesExpenseList) {
        this.expensesExpenseList = expensesExpenseList;
    }

    public List<ExpensesPerson> getExpensesPersonList() {
        return expensesPersonList;
    }

    public void setExpensesPersonList(List<ExpensesPerson> expensesPayerList) {
        this.expensesPersonList = expensesPayerList;
    }

    public List<AccountExpenses> getAccountExpensesList() {
        return accountExpensesList;
    }

    public void setAccountExpensesList(List<AccountExpenses> accountExpensesList) {
        this.accountExpensesList = accountExpensesList;
    }

    public List<ExpensesHistory> getExpensesHistoryList() {
        return expensesHistoryList;
    }

    public void setExpensesHistoryList(List<ExpensesHistory> expensesHistoryList) {
        this.expensesHistoryList = expensesHistoryList;
    }
}
