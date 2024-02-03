package com.app.FO.model.account;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_topic")
public class AccountTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_topic_seq")
    @SequenceGenerator(name = "account_topic_seq",
            sequenceName = "account_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "account_date")
    private LocalDateTime accountDate;

    public AccountTopic() {
    }

    public AccountTopic(Account account, Topic topic) {
        this.account = account;
        this.topic = topic;
        this.accountDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AccountTopic{" +
                "id=" + id +
                ", accountId=" + account.getId() +
                ", topicId=" + topic.getId() +
                ", accountDate=" + accountDate +
                '}';
    }
}
