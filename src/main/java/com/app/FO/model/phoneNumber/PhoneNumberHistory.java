package com.app.FO.model.phoneNumber;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_history")
public class PhoneNumberHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneNumber_history_seq")
    @SequenceGenerator(name = "phoneNumber_history_seq",
            sequenceName = "phoneNumber_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "phoneNumber_history_id")
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "phoneNumber_id")
    @JsonIgnore
    private PhoneNumber phoneNumber;

    public PhoneNumberHistory() {
    }

    @Override
    public String toString() {
        return "PhoneNumberHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", taskListId=" + phoneNumber.getId() +
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

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
