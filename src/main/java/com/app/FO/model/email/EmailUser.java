package com.app.FO.model.email;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "email_user")
public class EmailUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_user_seq")
    @SequenceGenerator(name = "email_user_seq",
            sequenceName = "email_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "email_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "email_id")
    @JsonIgnore
    private Email email;

    @Column(name = "email_date")
    private LocalDateTime emailDate;

    public EmailUser() {
    }

    public EmailUser(Email email, User user) {
        this.user = user;
        this.email = email;
        this.emailDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EmailTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", email=" + email.getId() +
                ", emailDate=" + emailDate +
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public LocalDateTime getEmailDate() {
        return emailDate;
    }

    public void setEmailDate(LocalDateTime emailDate) {
        this.emailDate = emailDate;
    }
}
