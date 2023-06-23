package com.app.FO.model.expense;

import com.app.FO.model.expenses.Expenses;
import com.app.FO.model.product.Product;
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

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @Column(name = "subject")
    private String subject;

    @Column(name = "check")
    private Boolean check;
    @Column(name = "category")
    private String category;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "estimated_price")
    private Double estimatedPrice;
    @Column(name = "check_date")
    private LocalDateTime checkDate;

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
    private List<ExpenseHistory> expenseHistoryList;

    public Expense() {
    }

    public Expense(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expenses=" + expenses +
                ", product=" + product +
                ", subject='" + subject + '\'' +
                ", check=" + check +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", estimatedPrice=" + estimatedPrice +
                ", checkDate=" + checkDate +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", expenseUserList=" + expenseUserList +
                ", expenseTagList=" + expenseTagList +
                ", expenseReminderList=" + expenseReminderList +
                ", expenseTopicList=" + expenseTopicList +
                ", expenseTasksList=" + expenseTasksList +
                ", expenseHistoryList=" + expenseHistoryList +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(Double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public LocalDateTime getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(LocalDateTime checkDate) {
        this.checkDate = checkDate;
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

    public List<ExpenseHistory> getExpenseHistoryList() {
        return expenseHistoryList;
    }

    public void setExpenseHistoryList(List<ExpenseHistory> expenseHistoryList) {
        this.expenseHistoryList = expenseHistoryList;
    }
}
