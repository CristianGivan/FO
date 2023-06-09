package com.app.FO.model.shop;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_history")
public class ShopHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_history_seq")
    @SequenceGenerator(name = "shop_history_seq",
            sequenceName = "shop_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "shop_history_id")
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @JsonIgnore
    private Shop shop;

    public ShopHistory() {
    }

    @Override
    public String toString() {
        return "ShopHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", taskListId=" + shop.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
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
}
