package com.app.FO.model.expenses;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_user")
public class ExpensesUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_users_seq")
    @SequenceGenerator(name = "expenses_users_seq",
            sequenceName = "expenses_users_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_users_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public ExpensesUser() {
    }

    @Override
    public String toString() {
        return "ExpensesUser{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", expensesId=" + expenses.getId() +
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

    public Expenses getExpensesList() {
        return expenses;
    }

    public void setExpensesList(Expenses expenses) {
        this.expenses = expenses;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
