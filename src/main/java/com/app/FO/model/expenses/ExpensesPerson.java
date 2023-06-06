package com.app.FO.model.expenses;

import com.app.FO.model.person.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_person")
public class ExpensesPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_person_seq")
    @SequenceGenerator(name = "expenses_person_seq",
            sequenceName = "expenses_person_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_person_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @Column(name = "expenses_date")
    private LocalDateTime expensesDate;

    public ExpensesPerson() {
    }

    public ExpensesPerson(Expenses expenses, Person person) {
        this.person = person;
        this.expenses = expenses;
        this.expensesDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExpensesTasks{" +
                "id=" + id +
                ", taskId=" + person.getId() +
                ", expenses=" + expenses.getId() +
                ", expensesDate=" + expensesDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    public LocalDateTime getExpensesDate() {
        return expensesDate;
    }

    public void setExpensesDate(LocalDateTime expensesDate) {
        this.expensesDate = expensesDate;
    }
}
