package com.app.FO.model.expense;

import com.app.FO.model.expenses.ExpensesExpense;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_seq")
    @SequenceGenerator(name = "expense_seq",
            sequenceName = "expense_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expense_id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "producer")
    private String producer;
    @Column(name = "subject")
    private String subject;
    @Column(name = "category")
    private String category;
    @Column(name = "number_buys")
    private Integer numberOfBuys;
    @Column(name = "number_mean")
    private Integer numberForMean;
    @Column(name = "mean_quantity")
    private Double meanQuantity;
    @Column(name = "mean_unit_price")
    private Double meanUnitPrice;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;
    @OneToMany(mappedBy = "expense", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseUser> expenseUserList;

    @OneToMany(mappedBy = "expense", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseTag> expenseTagList;

    @OneToMany(mappedBy = "expense", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseReminder> expenseReminderList;


    @OneToMany(mappedBy = "expense", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseTopic> expenseTopicList;

    @OneToMany(mappedBy = "expense", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseTasks> expenseTasksList;

    @OneToMany(mappedBy = "expense", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesExpense> expensesExpenseList;

    @OneToMany(mappedBy = "expense", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseHistory> expenseHistoryList;

    public Expense() {
    }

    public Expense(String name, String producer, User creator) {
        this.subject = name;
        this.subject = producer;
        this.subject = name + " from " + producer;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", subject='" + subject + '\'' +
                ", category='" + category + '\'' +
                ", numberOfBuys=" + numberOfBuys +
                ", numberForMean=" + numberForMean +
                ", meanQuantity=" + meanQuantity +
                ", meanUnitPrice=" + meanUnitPrice +
                ", createdDate=" + createdDate +
                ", creator=" + creator.getId() +
                ", expenseUserList=" + expenseUserList +
                ", expenseTagList=" + expenseTagList +
                ", expenseReminderList=" + expenseReminderList +
                ", expenseTopicList=" + expenseTopicList +
                ", expenseTasksList=" + expenseTasksList +
                ", expensesExpenseList=" + expensesExpenseList +
                ", expenseHistoryList=" + expenseHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        if (name == null) {
            name = "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        if (producer == null) {
            producer = "";
        }
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNumberOfBuys() {
        return numberOfBuys;
    }

    public void setNumberOfBuys(Integer numberOfBuys) {
        this.numberOfBuys = numberOfBuys;
    }

    public Integer getNumberForMean() {
        return numberForMean;
    }

    public void setNumberForMean(Integer numberForMean) {
        this.numberForMean = numberForMean;
    }

    public Double getMeanQuantity() {
        return meanQuantity;
    }

    public void setMeanQuantity(Double meanQuantity) {
        this.meanQuantity = meanQuantity;
    }

    public Double getMeanUnitPrice() {
        return meanUnitPrice;
    }

    public void setMeanUnitPrice(Double meanUnitPrice) {
        this.meanUnitPrice = meanUnitPrice;
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

    public List<ExpenseUser> getExpenseUserList() {
        if (expenseUserList == null) {
            expenseUserList = new ArrayList<>();
        }
        return expenseUserList;
    }

    public void setExpenseUserList(List<ExpenseUser> expenseUserList) {
        this.expenseUserList = expenseUserList;
    }

    public List<ExpenseTag> getExpenseTagList() {
        return expenseTagList;
    }

    public void setExpenseTagList(List<ExpenseTag> expenseTagList) {
        this.expenseTagList = expenseTagList;
    }

    public List<ExpenseReminder> getExpenseReminderList() {
        return expenseReminderList;
    }

    public void setExpenseReminderList(List<ExpenseReminder> expenseReminderList) {
        this.expenseReminderList = expenseReminderList;
    }


    public List<ExpenseTopic> getExpenseTopicList() {
        return expenseTopicList;
    }

    public void setExpenseTopicList(List<ExpenseTopic> expenseTopicList) {
        this.expenseTopicList = expenseTopicList;
    }

    public List<ExpenseTasks> getExpenseTasksList() {
        return expenseTasksList;
    }

    public void setExpenseTasksList(List<ExpenseTasks> expenseTasksList) {
        this.expenseTasksList = expenseTasksList;
    }


    public List<ExpensesExpense> getExpensesExpenseList() {
        return expensesExpenseList;
    }

    public void setExpensesExpenseList(List<ExpensesExpense> expensesExpenseList) {
        this.expensesExpenseList = expensesExpenseList;
    }

    public List<ExpenseHistory> getExpenseHistoryList() {
        return expenseHistoryList;
    }

    public void setExpenseHistoryList(List<ExpenseHistory> expenseHistoryList) {
        this.expenseHistoryList = expenseHistoryList;
    }
}
