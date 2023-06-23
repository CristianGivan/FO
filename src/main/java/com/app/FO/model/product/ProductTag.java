package com.app.FO.model.product;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_tag")
public class ProductTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_tag_seq")
    @SequenceGenerator(name = "product_tag_seq",
            sequenceName = "product_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "product_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "product_date")
    private LocalDateTime productDate;

    public ProductTag() {
    }

    public ProductTag(Product product, Tag tag) {
        this.product = product;
        this.tag = tag;
        this.productDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ProductTag{" +
                "id=" + id +
                ", productId=" + product.getId() +
                ", tagId=" + tag.getId() +
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getProductDate() {
        return productDate;
    }

    public void setProductDate(LocalDateTime productDate) {
        this.productDate = productDate;
    }
}
