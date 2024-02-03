package com.app.FO.model.transaction;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_topic")
public class TransactionTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_topic_seq")
    @SequenceGenerator(name = "transaction_topic_seq",
            sequenceName = "transaction_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "transaction_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonIgnore
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    public TransactionTopic() {
    }

    public TransactionTopic(Transaction transaction, Topic topic) {
        this.transaction = transaction;
        this.topic = topic;
        this.transactionDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TransactionTopic{" +
                "id=" + id +
                ", transactionId=" + transaction.getId() +
                ", topicId=" + topic.getId() +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
