package com.app.FO.model.expenses;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_tag")
public class ExpensesTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_tag_seq")
    @SequenceGenerator(name = "expenses_tag_seq",
            sequenceName = "expenses_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public ExpensesTag() {
    }

    @Override
    public String toString() {
        return "ExpensesTag{" +
                "id=" + id +
                ", expensesId=" + expenses.getId() +
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

    public Expenses getExpensesList() {
        return expenses;
    }

    public void setExpensesList(Expenses expenses) {
        this.expenses = expenses;
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
