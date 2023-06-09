package com.app.FO.mapper.dto.shop;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class ShopDTO {
    private Long shopId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public ShopDTO(Long shopId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.shopId = shopId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "ShopDTO{" +
                "shopId=" + shopId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }
}
