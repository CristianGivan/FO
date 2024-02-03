package com.app.FO.model.shop;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_topic")
public class ShopTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_topic_seq")
    @SequenceGenerator(name = "shop_topic_seq",
            sequenceName = "shop_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "shop_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @JsonIgnore
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "shop_date")
    private LocalDateTime shopDate;

    public ShopTopic() {
    }

    public ShopTopic(Shop shop, Topic topic) {
        this.shop = shop;
        this.topic = topic;
        this.shopDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ShopTopic{" +
                "id=" + id +
                ", shopId=" + shop.getId() +
                ", topicId=" + topic.getId() +
                ", shopDate=" + shopDate +
                '}';
    }
}
