package com.app.FO.mapper.dto.expenses;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class ExpensesDTO {
    private Long expensesId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public ExpensesDTO(Long expensesId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.expensesId = expensesId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "ExpensesDTO{" +
                "expensesId=" + expensesId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(Long expensesId) {
        this.expensesId = expensesId;
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
