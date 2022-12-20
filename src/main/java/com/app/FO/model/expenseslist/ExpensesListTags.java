package com.app.FO.model.expenseslist;

import com.app.FO.model.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_list_tags")
public class ExpensesListTags {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_list_tags_seq")
    @SequenceGenerator(name = "expenses_list_tags_seq",
            sequenceName = "expenses_list_tags_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_list_tags_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expenses_list_id")
    @JsonIgnore
    private ExpensesList expensesList;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public ExpensesListTags() {
    }

    @Override
    public String toString() {
        return "ExpensesListTags{" +
                "id=" + id +
                ", expensesListId=" + expensesList.getId() +
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

    public ExpensesList getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(ExpensesList expensesList) {
        this.expensesList = expensesList;
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
