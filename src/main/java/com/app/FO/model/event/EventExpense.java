package com.app.FO.model.event;

import com.app.FO.model.expenses.Expenses;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_expense")
public class EventExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_expense_seq")
    @SequenceGenerator(name = "event_expense_seq",
            sequenceName = "event_expense_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_expense_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    @JsonIgnore
    private Expenses expenses;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public EventExpense() {
    }

    @Override
    public String toString() {
        return "EventExpense{" +
                "id=" + id +
                ", eventId=" + event.getId() +
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
