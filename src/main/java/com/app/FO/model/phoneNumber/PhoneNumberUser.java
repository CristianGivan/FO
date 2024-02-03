package com.app.FO.model.phoneNumber;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "phoneNumber_user")
public class PhoneNumberUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneNumber_user_seq")
    @SequenceGenerator(name = "phoneNumber_user_seq",
            sequenceName = "phoneNumber_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "phoneNumber_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "phoneNumber_id")
    @JsonIgnore
    private PhoneNumber phoneNumber;

    @Column(name = "phoneNumber_date")
    private LocalDateTime phoneNumberDate;

    public PhoneNumberUser() {
    }

    public PhoneNumberUser(PhoneNumber phoneNumber, User user) {
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.phoneNumberDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PhoneNumberTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", phoneNumber=" + phoneNumber.getId() +
                ", phoneNumberDate=" + phoneNumberDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getPhoneNumberDate() {
        return phoneNumberDate;
    }

    public void setPhoneNumberDate(LocalDateTime phoneNumberDate) {
        this.phoneNumberDate = phoneNumberDate;
    }
}
