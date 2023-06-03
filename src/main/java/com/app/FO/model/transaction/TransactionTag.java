package com.app.FO.model.transaction;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_tag")
public class TransactionTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_tag_seq")
    @SequenceGenerator(name = "transaction_tag_seq",
            sequenceName = "transaction_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "transaction_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonIgnore
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    public TransactionTag() {
    }

    public TransactionTag(Transaction transaction, Tag tag) {
        this.transaction = transaction;
        this.tag = tag;
        this.transactionDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TransactionTag{" +
                "id=" + id +
                ", transactionId=" + transaction.getId() +
                ", tagId=" + tag.getId() +
                ", transactionDate=" + transactionDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
