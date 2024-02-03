package com.app.FO.model.shop;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_reminder")
public class ShopReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_reminder_seq")
    @SequenceGenerator(name = "shop_reminder_seq",
            sequenceName = "shop_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "shop_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @JsonIgnore
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "shop_date")
    private LocalDateTime shopDate;

    public ShopReminder() {
    }

    public ShopReminder(Shop shop, Reminder reminder) {
        this.shop = shop;
        this.reminder = reminder;
        this.shopDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ShopReminder{" +
                "id=" + id +
                ", shopId=" + shop.getId() +
                ", reminderId=" + reminder.getId() +
                ", shopDate=" + shopDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getShopDate() {
        return shopDate;
    }

    public void setShopDate(LocalDateTime shopDate) {
        this.shopDate = shopDate;
    }
}
