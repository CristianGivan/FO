package com.app.FO.model.product;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_tasks")
public class ProductTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_tasks_seq")
    @SequenceGenerator(name = "product_tasks_seq",
            sequenceName = "product_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "product_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @Column(name = "product_date")
    private LocalDateTime productDate;

    public ProductTasks() {
    }

    public ProductTasks(Product product, Tasks tasks) {
        this.product = product;
        this.tasks = tasks;
        this.productDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ProductTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
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

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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
