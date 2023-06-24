package com.app.FO.model.shop;

import com.app.FO.model.expenses.Expenses;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_seq")
    @SequenceGenerator(name = "shop_seq",
            sequenceName = "shop_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "shop_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "name")
    private String name;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "shop", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ShopUser> shopUserList;

    @OneToMany(mappedBy = "shop", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ShopTag> shopTagList;

    @OneToMany(mappedBy = "shop", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ShopReminder> shopReminderList;

    @OneToMany(mappedBy = "shop", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ShopTopic> shopTopicList;

    @OneToMany(mappedBy = "shop", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ShopTasks> shopTasksList;

    @OneToMany(mappedBy = "shop", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Expenses> expensesList;
    @OneToMany(mappedBy = "shop", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ShopHistory> shopHistoryList;


    public Shop() {
    }

    public Shop(String subject, String name, User creator) {
        this.subject = subject;
        this.name = name;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", shopUserList=" + shopUserList +
                ", shopTagList=" + shopTagList +
                ", shopReminderList=" + shopReminderList +
                ", shopTopicList=" + shopTopicList +
                ", shopTasksList=" + shopTasksList +
                ", expenses=" + expensesList +
                ", shopHistoryList=" + shopHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        if (subject == null) {
            subject = "";
        }
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public List<ShopUser> getShopUserList() {
        if (shopUserList == null) {
            shopUserList = new ArrayList<>();
        }
        return shopUserList;
    }

    public void setShopUserList(List<ShopUser> shopUserList) {
        this.shopUserList = shopUserList;
    }

    public List<ShopTag> getShopTagList() {
        if (shopTagList == null) {
            shopTagList = new ArrayList<>();
        }
        return shopTagList;
    }

    public void setShopTagList(List<ShopTag> shopTagList) {
        this.shopTagList = shopTagList;
    }

    public List<ShopReminder> getShopReminderList() {
        if (shopReminderList == null) {
            shopReminderList = new ArrayList<>();
        }
        return shopReminderList;
    }

    public void setShopReminderList(List<ShopReminder> shopReminderList) {
        this.shopReminderList = shopReminderList;
    }


    public List<ShopTopic> getShopTopicList() {
        if (shopTopicList == null) {
            shopTopicList = new ArrayList<>();
        }
        return shopTopicList;
    }

    public void setShopTopicList(List<ShopTopic> shopTopicList) {
        this.shopTopicList = shopTopicList;
    }

    public List<ShopTasks> getShopTasksList() {
        if (shopTasksList == null) {
            shopTasksList = new ArrayList<>();
        }
        return shopTasksList;
    }

    public void setShopTasksList(List<ShopTasks> shopTasksList) {
        this.shopTasksList = shopTasksList;
    }

    public List<Expenses> getExpensesList() {
        if (expensesList == null) {
            expensesList = new ArrayList<>();
        }
        return expensesList;
    }

    public void setExpensesList(List<Expenses> expensesList) {
        this.expensesList = expensesList;
    }

    public List<ShopHistory> getShopHistoryList() {
        if (shopHistoryList == null) {
            shopHistoryList = new ArrayList<>();
        }
        return shopHistoryList;
    }

    public void setShopHistoryList(List<ShopHistory> shopHistoryList) {
        this.shopHistoryList = shopHistoryList;
    }
}
