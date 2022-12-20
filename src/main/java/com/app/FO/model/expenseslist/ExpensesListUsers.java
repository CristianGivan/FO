package com.app.FO.model.expenseslist;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_list_users")
public class ExpensesListUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_list_users_seq")
    @SequenceGenerator(name = "expenses_list_users_seq",
            sequenceName = "expenses_list_users_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_list_users_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "expences_list_id")
    @JsonIgnore
    private ExpensesList expensesList;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public ExpensesListUsers() {
    }

    @Override
    public String toString() {
        return "ExpensesListUsers{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", expensesListId=" + expensesList.getId() +
                ", linkDate=" + linkDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ExpensesList getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(ExpensesList expensesList) {
        this.expensesList = expensesList;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
