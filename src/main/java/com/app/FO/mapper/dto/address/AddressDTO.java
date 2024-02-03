package com.app.FO.mapper.dto.address;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class AddressDTO {
    private Long addressId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public AddressDTO(Long addressId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.addressId = addressId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "addressId=" + addressId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
