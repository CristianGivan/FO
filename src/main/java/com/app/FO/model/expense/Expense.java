package com.app.FO.model.expense;

import com.app.FO.model.expenses.ExpensesExpense;
import com.app.FO.model.product.ProductExpense;
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


    @Column(name = "subject")
    private String subject;

    @Column(name = "checked")
    private Boolean checked;
    @Column(name = "category")
    private String category;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "mean_quantity")
    private Double meanQuantity;
    @Column(name = "mean_unit_price")
    private Double meanUnitPrice;

    @Column(name = "estimated_total_price")
    private Double estimatedTotalPrice;
    @Column(name = "checked_date")
    private LocalDateTime checkedDate;

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
    private List<ProductExpense> productExpenseList;
    @OneToMany(mappedBy = "expense", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesExpense> expensesExpenseList;
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
                ", subject='" + subject + '\'' +
                ", checked=" + checked +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", meanQuantity=" + meanQuantity +
                ", meanUnitPrice=" + meanUnitPrice +
                ", estimatedTotalPrice=" + estimatedTotalPrice +
                ", checkedDate=" + checkedDate +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", expenseUserList=" + expenseUserList +
                ", expenseTagList=" + expenseTagList +
                ", expenseReminderList=" + expenseReminderList +
                ", expenseTopicList=" + expenseTopicList +
                ", expenseTasksList=" + expenseTasksList +
                ", productExpenseList=" + productExpenseList +
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


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getChecked() {
        if (checked == null) {
            checked = false;
        }
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getQuantity() {
        if (quantity == null) {
            quantity = 0.0;
        }
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        if (unitPrice == null) {
            unitPrice = 0.0;
        }
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotalPrice() {
        if (totalPrice == null) {
            totalPrice = 0.0;
        }
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getEstimatedTotalPrice() {
        if (estimatedTotalPrice == null) {
            estimatedTotalPrice = 0.0;
        }
        return estimatedTotalPrice;
    }

    public void setEstimatedTotalPrice(Double estimatedTotalPrice) {
        this.estimatedTotalPrice = estimatedTotalPrice;
    }

    public Double getMeanQuantity() {
        if (meanQuantity == null) {
            meanQuantity = 0.0;
        }
        return meanQuantity;
    }

    public void setMeanQuantity(Double meanQuantity) {
        this.meanQuantity = meanQuantity;
    }

    public Double getMeanUnitPrice() {
        if (meanUnitPrice == null) {
            meanUnitPrice = 0.0;
        }
        return meanUnitPrice;
    }

    public void setMeanUnitPrice(Double meanUnitPrice) {
        this.meanUnitPrice = meanUnitPrice;
    }

    public LocalDateTime getCheckedDate() {
        return checkedDate;
    }

    public void setCheckedDate(LocalDateTime checkedDate) {
        this.checkedDate = checkedDate;
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

    public List<ProductExpense> getProductExpenseList() {
        return productExpenseList;
    }

    public void setProductExpenseList(List<ProductExpense> productExpenseList) {
        this.productExpenseList = productExpenseList;
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
