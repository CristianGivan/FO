package com.app.FO.model.expenses;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_topic")
public class ExpensesTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_topic_seq")
    @SequenceGenerator(name = "expenses_topic_seq",
            sequenceName = "expenses_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "expenses_date")
    private LocalDateTime expensesDate;

    public ExpensesTopic() {
    }

    public ExpensesTopic(Expenses expenses, Topic topic) {
        this.expenses = expenses;
        this.topic = topic;
        this.expensesDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExpensesTopic{" +
                "id=" + id +
                ", expensesId=" + expenses.getId() +
                ", topicId=" + topic.getId() +
                ", expensesDate=" + expensesDate +
                '}';
    }
}
