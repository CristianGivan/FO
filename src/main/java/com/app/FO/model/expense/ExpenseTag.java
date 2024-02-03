package com.app.FO.model.expense;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense_tag")
public class ExpenseTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_tag_seq")
    @SequenceGenerator(name = "expense_tag_seq",
            sequenceName = "expense_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expense_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    @JsonIgnore
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "expense_date")
    private LocalDateTime expenseDate;

    public ExpenseTag() {
    }

    public ExpenseTag(Expense expense, Tag tag) {
        this.expense = expense;
        this.tag = tag;
        this.expenseDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExpenseTag{" +
                "id=" + id +
                ", expenseId=" + expense.getId() +
                ", tagId=" + tag.getId() +
                ", expenseDate=" + expenseDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }
}
