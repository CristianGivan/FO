package com.app.FO.model.event;

import com.app.FO.model.expenses.Expenses;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_expense")
@Getter
@Setter
@NoArgsConstructor
public class EventExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_expense_seq")
    @SequenceGenerator(name = "event_expense_seq",
            sequenceName = "event_expense_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_expense_id")
    @Setter(AccessLevel.NONE)
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

    @Override
    public String toString() {
        return "EventExpense{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", expensesId=" + expenses.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
