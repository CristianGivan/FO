package com.app.FO.model.expense;

import com.app.FO.model.expenses.Expenses;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private String expanseName;

    @Column(name = "details")
    private String details;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "unit")
    private String unit;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "created_date")
    private LocalDateTime createDate;

    @Column(name = "paid_date")
    private LocalDateTime paidDate;

    @Column(name = "market")
    private String market;

    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "creator_id")
    @JsonIgnore
    private User creator;

    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "payer_id")
    @JsonIgnore
    private User payer;

    @OneToMany(mappedBy = "expense", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseTag> expenseTags;

    @ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    public Expense() {
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expanseName='" + expanseName + '\'' +
                ", details='" + details + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", unitPrice=" + unitPrice +
                ", createDate=" + createDate +
                ", paidDate=" + paidDate +
                ", market='" + market + '\'' +
                ", creatorId=" + creator.getId() +
                ", payerId=" + payer.getId() +
                ", expenseTags=" + expenseTags +
                ", expensesId=" + expenses.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpanseName() {
        return expanseName;
    }

    public void setExpanseName(String expanseName) {
        this.expanseName = expanseName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDateTime paidDate) {
        this.paidDate = paidDate;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public List<ExpenseTag> getExpenseTags() {
        return expenseTags;
    }

    public void setExpenseTags(List<ExpenseTag> expenseTags) {
        this.expenseTags = expenseTags;
    }

    public Expenses getExpensesList() {
        return expenses;
    }

    public void setExpensesList(Expenses expenses) {
        this.expenses = expenses;
    }
}
