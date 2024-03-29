package com.app.FO.model.product;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq",
            sequenceName = "product_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "name")
    private String name;

    @Column(name = "unit")
    private String unit;
    @Column(name = "category")
    private String category;

    @Column(name = "producer")
    private String producer;

    @Column(name = "number_buys")
    private Integer numberOfBuys;
    @Column(name = "number_mean_quantity")
    private Integer numberForMeanQuantity;
    @Column(name = "number_mean_price")
    private Integer numberForMeanPrice;
    @Column(name = "mean_quantity")
    private Double meanQuantity;
    @Column(name = "mean_unit_price")
    private Double meanUnitPrice;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;
    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProductUser> productUserList;

    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProductTag> productTagList;

    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProductReminder> productReminderList;


    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProductTopic> productTopicList;

    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProductTasks> productTasksList;

    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProductExpense> productExpenseList;

    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ProductHistory> productHistoryList;

    public Product() {
    }

    public Product(String name, String unit, User creator) {
        this.name = name;
        this.unit = unit;
        this.subject = name + " (" + unit + ")";
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", category='" + category + '\'' +
                ", producer='" + producer + '\'' +
                ", numberOfBuys=" + numberOfBuys +
                ", numberForMeanQuantity=" + numberForMeanQuantity +
                ", numberForMeanPrice=" + numberForMeanPrice +
                ", meanQuantity=" + meanQuantity +
                ", meanUnitPrice=" + meanUnitPrice +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", productUserList=" + productUserList +
                ", productTagList=" + productTagList +
                ", productReminderList=" + productReminderList +
                ", productTopicList=" + productTopicList +
                ", productTasksList=" + productTasksList +
                ", productExpenseList=" + productExpenseList +
                ", productHistoryList=" + productHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        if (name == null) {
            name = "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProducer() {
        if (producer == null) {
            producer = "";
        }
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNumberOfBuys() {
        return numberOfBuys;
    }

    public void setNumberOfBuys(Integer numberOfBuys) {
        this.numberOfBuys = numberOfBuys;
    }


    public Integer getNumberForMeanQuantity() {
        return numberForMeanQuantity;
    }

    public void setNumberForMeanQuantity(Integer numberForMeanQuantity) {
        this.numberForMeanQuantity = numberForMeanQuantity;
    }

    public Integer getNumberForMeanPrice() {
        return numberForMeanPrice;
    }

    public void setNumberForMeanPrice(Integer numberForMeanPrice) {
        this.numberForMeanPrice = numberForMeanPrice;
    }

    public Double getMeanQuantity() {
        if (meanQuantity == null) {
            meanQuantity = 0.0;
        }
        return meanQuantity;
    }

    public void setMeanQuantity(Double meanQuantity) {
        this.meanQuantity = meanQuantity;
    }

    public Double getMeanUnitPrice() {
        if (meanUnitPrice == null) {
            meanUnitPrice = 0.0;
        }
        return meanUnitPrice;
    }

    public void setMeanUnitPrice(Double meanUnitPrice) {
        this.meanUnitPrice = meanUnitPrice;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<ProductUser> getProductUserList() {
        if (productUserList == null) {
            productUserList = new ArrayList<>();
        }
        return productUserList;
    }

    public void setProductUserList(List<ProductUser> productUserList) {
        this.productUserList = productUserList;
    }

    public List<ProductTag> getProductTagList() {
        return productTagList;
    }

    public void setProductTagList(List<ProductTag> productTagList) {
        this.productTagList = productTagList;
    }

    public List<ProductReminder> getProductReminderList() {
        return productReminderList;
    }

    public void setProductReminderList(List<ProductReminder> productReminderList) {
        this.productReminderList = productReminderList;
    }


    public List<ProductTopic> getProductTopicList() {
        return productTopicList;
    }

    public void setProductTopicList(List<ProductTopic> productTopicList) {
        this.productTopicList = productTopicList;
    }

    public List<ProductTasks> getProductTasksList() {
        return productTasksList;
    }

    public void setProductTasksList(List<ProductTasks> productTasksList) {
        this.productTasksList = productTasksList;
    }

    public List<ProductExpense> getProductExpenseList() {
        if (productExpenseList == null) {
            productExpenseList = new ArrayList<>();
        }
        return productExpenseList;
    }

    public void setProductExpenseList(List<ProductExpense> productExpenseList) {
        this.productExpenseList = productExpenseList;
    }

    public List<ProductHistory> getProductHistoryList() {
        return productHistoryList;
    }

    public void setProductHistoryList(List<ProductHistory> productHistoryList) {
        this.productHistoryList = productHistoryList;
    }
}
