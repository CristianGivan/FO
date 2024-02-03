package com.app.FO.model.product;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_topic")
public class ProductTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_topic_seq")
    @SequenceGenerator(name = "product_topic_seq",
            sequenceName = "product_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "product_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "product_date")
    private LocalDateTime productDate;

    public ProductTopic() {
    }

    public ProductTopic(Product product, Topic topic) {
        this.product = product;
        this.topic = topic;
        this.productDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ProductTopic{" +
                "id=" + id +
                ", productId=" + product.getId() +
                ", topicId=" + topic.getId() +
                ", productDate=" + productDate +
                '}';
    }
}
