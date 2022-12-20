package com.app.FO.model.event;

import com.app.FO.model.expenseslist.ExpensesList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_expense_lists")
public class EventExpenseLists {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_expense_lists_seq")
    @SequenceGenerator(name = "event_expense_lists_seq",
            sequenceName = "event_expense_lists_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_expense_lists_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "expense_lists_id")
    @JsonIgnore
    private ExpensesList expensesList;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public EventExpenseLists() {
    }

    @Override
    public String toString() {
        return "EventExpenseLists{" +
                "id=" + id +
                ", eventId=" + event.getId() +
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
