package com.app.FO.model.expense;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense_topic")
public class ExpenseTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_topic_seq")
    @SequenceGenerator(name = "expense_topic_seq",
            sequenceName = "expense_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expense_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    @JsonIgnore
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "expense_date")
    private LocalDateTime expenseDate;

    public ExpenseTopic() {
    }

    public ExpenseTopic(Expense expense, Topic topic) {
        this.expense = expense;
        this.topic = topic;
        this.expenseDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExpenseTopic{" +
                "id=" + id +
                ", expenseId=" + expense.getId() +
                ", topicId=" + topic.getId() +
                ", expenseDate=" + expenseDate +
                '}';
    }
}
