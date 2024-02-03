package com.app.FO.model.shop;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_tasks")
public class ShopTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_tasks_seq")
    @SequenceGenerator(name = "shop_tasks_seq",
            sequenceName = "shop_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "shop_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @JsonIgnore
    private Shop shop;

    @Column(name = "shop_date")
    private LocalDateTime shopDate;

    public ShopTasks() {
    }

    public ShopTasks(Shop shop, Tasks tasks) {
        this.shop = shop;
        this.tasks = tasks;
        this.shopDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ShopTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
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

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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
