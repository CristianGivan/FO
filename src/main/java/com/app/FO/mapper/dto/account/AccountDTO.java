package com.app.FO.mapper.dto.account;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class AccountDTO {
    private Long accountId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public AccountDTO(Long accountId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.accountId = accountId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "accountId=" + accountId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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
