package com.app.FO.mapper.dto.expense;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class ExpenseDTO {
    private Long expenseId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public ExpenseDTO(Long expenseId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.expenseId = expenseId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "ExpenseDTO{" +
                "expenseId=" + expenseId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
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
