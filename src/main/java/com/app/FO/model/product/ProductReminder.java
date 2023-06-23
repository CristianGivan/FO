package com.app.FO.model.product;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_reminder")
public class ProductReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_reminder_seq")
    @SequenceGenerator(name = "product_reminder_seq",
            sequenceName = "product_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "product_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "product_date")
    private LocalDateTime productDate;

    public ProductReminder() {
    }

    public ProductReminder(Product product, Reminder reminder) {
        this.product = product;
        this.reminder = reminder;
        this.productDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ProductReminder{" +
                "id=" + id +
                ", productId=" + product.getId() +
                ", reminderId=" + reminder.getId() +
                ", productDate=" + productDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getProductDate() {
        return productDate;
    }

    public void setProductDate(LocalDateTime productDate) {
        this.productDate = productDate;
    }
}
