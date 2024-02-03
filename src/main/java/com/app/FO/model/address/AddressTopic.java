package com.app.FO.model.address;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "address_topic")
public class AddressTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_topic_seq")
    @SequenceGenerator(name = "address_topic_seq",
            sequenceName = "address_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "address_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "address_date")
    private LocalDateTime addressDate;

    public AddressTopic() {
    }

    public AddressTopic(Address address, Topic topic) {
        this.address = address;
        this.topic = topic;
        this.addressDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AddressTopic{" +
                "id=" + id +
                ", addressId=" + address.getId() +
                ", topicId=" + topic.getId() +
                ", addressDate=" + addressDate +
                '}';
    }
}
