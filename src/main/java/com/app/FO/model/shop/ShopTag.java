package com.app.FO.model.shop;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_tag")
public class ShopTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_tag_seq")
    @SequenceGenerator(name = "shop_tag_seq",
            sequenceName = "shop_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "shop_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @JsonIgnore
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "shop_date")
    private LocalDateTime shopDate;

    public ShopTag() {
    }

    public ShopTag(Shop shop, Tag tag) {
        this.shop = shop;
        this.tag = tag;
        this.shopDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ShopTag{" +
                "id=" + id +
                ", shopId=" + shop.getId() +
                ", tagId=" + tag.getId() +
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getShopDate() {
        return shopDate;
    }

    public void setShopDate(LocalDateTime shopDate) {
        this.shopDate = shopDate;
    }
}
