package com.app.FO.mapper.dto.product;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class ProductDTO {
    private Long productId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public ProductDTO(Long productId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.productId = productId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
