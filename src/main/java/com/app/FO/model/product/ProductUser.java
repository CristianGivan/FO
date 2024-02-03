package com.app.FO.model.product;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_user")
public class ProductUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_user_seq")
    @SequenceGenerator(name = "product_user_seq",
            sequenceName = "product_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "product_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @Column(name = "product_date")
    private LocalDateTime productDate;

    public ProductUser() {
    }

    public ProductUser(Product product, User user) {
        this.user = user;
        this.product = product;
        this.productDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ProductTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", product=" + product.getId() +
                ", productDate=" + productDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getProductDate() {
        return productDate;
    }

    public void setProductDate(LocalDateTime productDate) {
        this.productDate = productDate;
    }
}
