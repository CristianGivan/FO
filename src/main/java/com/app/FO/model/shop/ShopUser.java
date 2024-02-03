package com.app.FO.model.shop;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_user")
public class ShopUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_user_seq")
    @SequenceGenerator(name = "shop_user_seq",
            sequenceName = "shop_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "shop_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @JsonIgnore
    private Shop shop;

    @Column(name = "shop_date")
    private LocalDateTime shopDate;

    public ShopUser() {
    }

    public ShopUser(Shop shop, User user) {
        this.user = user;
        this.shop = shop;
        this.shopDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ShopTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", shop=" + shop.getId() +
                ", shopDate=" + shopDate +
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

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public LocalDateTime getShopDate() {
        return shopDate;
    }

    public void setShopDate(LocalDateTime shopDate) {
        this.shopDate = shopDate;
    }
}
