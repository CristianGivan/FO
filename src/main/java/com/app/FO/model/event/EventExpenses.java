package com.app.FO.model.event;

import com.app.FO.model.expenses.Expenses;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_expenses")
public class EventExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_expenses_seq")
    @SequenceGenerator(name = "event_expenses_seq",
            sequenceName = "event_expenses_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_expenses_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    public EventExpenses() {
    }

    public EventExpenses(Event event, Expenses expenses) {
        this.event = event;
        this.expenses = expenses;
        this.eventDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EventExpenses{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", expensesId=" + expenses.getId() +
                ", eventDate=" + eventDate +
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

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
}
