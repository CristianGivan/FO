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

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public ExpenseTag() {
    }

    @Override
    public String toString() {
        return "ExpenseTag{" +
                "id=" + id +
                ", expenseId=" + expense.getId() +
                ", tagId=" + tag.getId() +
                ", linkDate=" + linkDate +
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

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
