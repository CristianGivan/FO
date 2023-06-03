package com.app.FO.mapper.dto.transaction;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class TransactionDTO {
    private Long transactionId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public TransactionDTO(Long transactionId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.transactionId = transactionId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "transactionId=" + transactionId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
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
