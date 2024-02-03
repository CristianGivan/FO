package com.app.FO.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_user")
public class UserUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_user_seq")
    @SequenceGenerator(name = "user_user_seq",
            sequenceName = "user_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "user_user_id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "date")
    private LocalDateTime allocatedDates;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "userLinked_id")
    @JsonIgnore
    private User userLinked;

    public UserUser() {
    }

    public UserUser(User user, User userLinked) {
        this.user = user;
        this.userLinked = userLinked;
        this.allocatedDates = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "UserUser{" +
                "id=" + id +
                ", user=" + user +
                ", allocatedDates=" + allocatedDates +
                ", userLinked=" + userLinked +
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

    public LocalDateTime getAllocatedDates() {
        return allocatedDates;
    }

    public void setAllocatedDates(LocalDateTime allocatedDates) {
        this.allocatedDates = allocatedDates;
    }

    public User getUserLinked() {
        return userLinked;
    }

    public void setUserLinked(User userLinked) {
        this.userLinked = userLinked;
    }
}
