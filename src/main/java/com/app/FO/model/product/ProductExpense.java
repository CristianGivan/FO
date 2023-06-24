package com.app.FO.model.product;

import com.app.FO.model.expense.Expense;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_expense")
public class ProductExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_expense_seq")
    @SequenceGenerator(name = "product_expense_seq",
            sequenceName = "product_expense_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "product_expense_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    @JsonIgnore
    private Expense expense;

    @Column(name = "product_date")
    private LocalDateTime productDate;

    public ProductExpense() {
    }

    public ProductExpense(Product product, Expense expense) {
        this.product = product;
        this.expense = expense;
        this.productDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ProductExpense{" +
                "id=" + id +
                ", productId=" + product.getId() +
                ", expenseId=" + expense.getId() +
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

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public LocalDateTime getProductDate() {
        return productDate;
    }

    public void setProductDate(LocalDateTime productDate) {
        this.productDate = productDate;
    }
}
